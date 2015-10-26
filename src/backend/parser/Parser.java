package backend.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import backend.factory.CommandFactory;
import backend.node.Node;
import datatransferobjects.UserInputTransferObject;
import responses.Error;
import responses.Response;
import sharedobjects.ManipulateController;


/**
 * @author wanning
 *
 */
public class Parser implements Observer {
	private ManipulateController myManiControl;
	private List<Node> myRoots;
	private int myIndex;
	private String myLanguage;
	private List<Entry<TokenType, String>> myTokenList; 
	private List<Entry<SyntaxType, String>> mySyntaxList; 
	private boolean myListLegal;
	private static final HashMap<String, TokenType> tokenMap = new HashMap<String, TokenType>(){{
		for(TokenType each:TokenType.values())
		{
			put(each.name().toUpperCase(), each);
		}
	}};
	private static final HashMap<String, SyntaxType> syntaxMap = new HashMap<String, SyntaxType>(){{
		for(SyntaxType each:SyntaxType.values())
		{
			put(each.name().toUpperCase(), each);
		}
	}};
	private static final HashMap<String, LangType> languageMap = new HashMap<String, LangType>(){{
		for(LangType each:LangType.values())
		{
			put(each.name().toUpperCase(), each);
		}
	}};
	private static final List<Entry<TokenType, Pattern>> myTokenPatterns = makeTokenPatterns("resources/languages/Syntax");
	public static final Map<LangType,List<Entry<SyntaxType, Pattern>>> mySyntaxPatterns = makeSyntaxPatterns(); 
	
	public Parser(ManipulateController mc) {
		//Call run to start.
		myManiControl=mc;
		init();
	}
	
	public void init(){
		myRoots = new ArrayList<Node>();
		myIndex=0;
		myListLegal=false;
	}
	
	public Response parse(String userInput, String lang) {
		myLanguage=lang;
		myTokenList=new ArrayList<Entry<TokenType, String>>();
		Response response = new Error("Haven't begin parsing");
		BufferedReader reader=new BufferedReader(new StringReader(userInput));
		String line;
		//lexicon parsing ("fd :#$@" is wrong)
		try {
			while((line=reader.readLine())!=null)
			{
				try{
					buildTokenList(line);
				}catch (LexiconException e) {
					response=new Error(e.getMessage());
					return response;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//syntax parsing ("fd fd" is wrong)
		try {
			buildSyntaxTree();
		} catch (SyntaxException e)
		{
			response = new Error(e.getMessage());
			return response;
		}
		for(Node each:myRoots)
		{
//			should add a try catch, and make executor throws execute exception
			response = each.run(myManiControl);
			System.out.println("--> " + response.toString());
//			System.out.println("call exec");
		}
		return response;
	}
	
	//a helper function to match regex
	public static boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }
	
	//return the list of tokens of this line. If there is a comment, discard this line.
	private List<Entry<TokenType, String>> generateToken(String line) throws LexiconException {
		List<Entry<TokenType, String>> result = new ArrayList<Entry<TokenType, String>>();
		StringTokenizer st=new StringTokenizer(line," ");
		String nodeName;
		boolean matchFlag=false;
		boolean commentFlag=false;
		while (st.hasMoreTokens())
		{
			nodeName=st.nextToken();
			for(Entry<TokenType, Pattern> p:myTokenPatterns)
			{
				if(match(nodeName, p.getValue()))
				{
					if(p.getKey()==TokenType.COMMENT){
						commentFlag=true;					
		            	break;
					}
					result.add(new SimpleEntry<TokenType, String>(p.getKey(), nodeName));
					matchFlag=true;
					break;
				}
			}
			if(commentFlag) break;
			if(!matchFlag) throw new LexiconException("Ilegal Input: Cannot find a matching token!");
		}
		return result;	
	}

	
	private void buildTokenList(String line) throws LexiconException{
		myTokenList.addAll(generateToken(line));
	}
	
	private void buildSyntaxTree() throws SyntaxException{
		//gengerate a syntax list
		mySyntaxList = new ArrayList<Entry<SyntaxType, String>>();
		for(Entry<TokenType, String> entry:myTokenList){
			switch(entry.getKey()){
			case CONSTANT: case VARIABLE: case LISTSTART: case LISTEND: case GROUPSTART: case GROUPEND:
				mySyntaxList.add(new SimpleEntry<SyntaxType, String>(syntaxMap.get(entry.getKey().name().toUpperCase()), entry.getValue()));
				break;
			case COMMAND:
				boolean matchFlag=false;
				for(Entry<SyntaxType, Pattern> p:mySyntaxPatterns.get(languageMap.get(myLanguage.toUpperCase())))
				{
					if(Parser.match(entry.getValue(), p.getValue()))
					{
						mySyntaxList.add(new SimpleEntry<SyntaxType, String>(p.getKey(), entry.getValue()));
						matchFlag=true;
						break;
					}
				}
				if(!matchFlag){
					mySyntaxList.add(new SimpleEntry<SyntaxType, String>(SyntaxType.USERCOMMAND, entry.getValue()));
//					throw new SyntaxException("Ilegal Input: Cannot find a matched command!");
				}
				break;
			default:
				throw new SyntaxException("Something is wrong.");
			}
			
		}
		//build syntax tree in a recursive way 
		while(myIndex<mySyntaxList.size()){
			Node root=null;
			root=growTree(); 
			if(root!=null){
				myRoots.add(root);
			}
		}
	}
	
	//index after growTree will indicate a token that hasn't been parsed
	//growTree will only generate one root or subroot in the tree
	private Node growTree() throws SyntaxException{
		try{
			//create the node using factory design pattern
			CommandFactory factory = new CommandFactory();
			SyntaxType type = mySyntaxList.get(myIndex).getKey();
			Node root = factory.createNode(type);
			root.setName(mySyntaxList.get(myIndex).getValue());
			myIndex++;
			//check the syntax and move on
			switch(type){
			//with 0 argument
			case CONSTANT:
				root.setValue(Double.parseDouble(mySyntaxList.get(myIndex-1).getValue()));
			case VARIABLE:case PENDOWN:case PENUP: case SHOWTURTLE :case HIDETURTLE:
			case HOME:case CLEARSCREEN:case XCOORDINATE:case YCOORDINATE:
			case HEADING: case ISPENDOWN: case ISSHOWING: case PI: case GETPENCOLOR: 
			case GETSHAPE: case STAMP: case CLEARSTAMP: case ID: case TURTLES:
				parseExpression(root,0);
				break;
			//with 1 argument
			case FORWARD:case BACKWARD:case LEFT: case RIGHT: case SETHEADING:
			case MINUS: case RANDOM:case SINE:case COSINE:case TANGENT:
			case ARCTANGENT:case NATURALLOG:case NOT: case SETBACKGROUND: case SETPENCOLOR:
			case SETPENSIZE: case SETSHAPE: 
				parseExpression(root,1);
				break;
			//with 2 arguments	
			case SETTOWARDS:case SETPOSITION:case SUM:case DIFFERENCE:
			case PRODUCT:case QUOTIENT:case REMAINDER:case POWER:
			case LESSTHAN:case GREATERTHAN:case EQUAL:case NOTEQUAL:
			case AND:case OR:
				parseExpression(root, 2);
			    break;
			//with 3 arguments
			case SETPALETTE: 
				parseExpression(root, 3);
				break;
			//control structures
			case GROUPSTART:
				root = factory.createNode(mySyntaxList.get(myIndex).getKey());
				root.setName(mySyntaxList.get(myIndex).getValue());
				myIndex++;
				parseGroupStart(root);
				break;
			case GROUPEND:
				throw new SyntaxException("Miss a left ( for" + root.getName());
			case LISTSTART:
				if(myListLegal){
					parseListStart(root);
					myListLegal=false;
				}
				else{
					throw new SyntaxException("Use " + root.getName() + "in illegal condition");
				}
				break;
			case LISTEND:
				throw new SyntaxException("Miss a left [ for" + root.getName());
			case MAKEVARIABLE:
				parseMakeVar(root);
				break;
			case REPEAT:
				parseRepeat(root);
				break;
			case DOTIMES:
				parseDoTimes(root);
				break;
			case FOR:
				parseFor(root);
				break;
			case IF:
				parseIf(root);
				break;
			case IFELSE:
				parseIfelse(root);
				break;
			case TELL:
				parseTell(root);
				break;
			case ASK:case ASKWITH:
				parseAsk(root);
				break;
			case MAKEUSERINSTRUCTION:
				parseMakeCmd(root);
				break;
			default:
				//root is USERCOMMAND
				Node toCmd = myManiControl.getCommand(mySyntaxList.get(myIndex).getValue());///////////maybe getFunction?
				if(toCmd==null)
					throw new SyntaxException("Undefined command!");
				int numOfArg=toCmd.getChildrenNum()-1;
				parseExpression(root, numOfArg);
			}
			return root;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted arguments list!");
		}
	}
	
	private void parseExpression(Node root, int numOfChildren) throws SyntaxException	{
		for(int i=0;i<numOfChildren;i++)
		{
			if(myIndex>=mySyntaxList.size())
				throw new SyntaxException("Uncompleted argument list in" + root.getName());
			Node c = growTree();
			root.addChild(c);
		}
	}
	
	private void parseMakeVar(Node root) throws SyntaxException{
		//make variable should be followed by variable and another expression
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.VARIABLE){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else{
				for(int i=0;i<2;i++){
					Node c = growTree();
					root.addChild(c);
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseRepeat(Node root) throws SyntaxException{
		//-----------------
		//might use parseExpression to support using a list as repeating times
		Node c = growTree();
		root.addChild(c);
		//-----------------
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else{
				//clist must be a LISTSTART syntax type
				myListLegal=true;
				Node clist = growTree();
				root.addChild(clist);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseListStart(Node root) throws SyntaxException{
		try{
			while(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTEND){
				Node c = growTree();
				root.addChild(c);
			}
			myIndex++;
			return;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Miss a right brace ] in "+root.getName());
		}
	}
	
	private void parseGroupStart(Node root) throws SyntaxException{
		SyntaxType type = mySyntaxList.get(myIndex-1).getKey(); 
		switch(type){
		case SUM: case EQUAL: case DIFFERENCE: case PRODUCT:
			try{
				CommandFactory factory = new CommandFactory();
				Node fakeRoot = root;
				while(mySyntaxList.get(myIndex+2).getKey()!=SyntaxType.GROUPEND){
					parseExpression(fakeRoot, 1);
					Node c = factory.createNode(type);
					fakeRoot.addChild(c);
					fakeRoot=c;
				}
				parseExpression(fakeRoot, 2);
				myIndex++;
			}catch(ArrayIndexOutOfBoundsException e){
				throw new SyntaxException("Miss a right brace ) in "+root.getName());
			}
			break;
		default:
			Node c=growTree();
			root.addChild(c);
			try{
				while(mySyntaxList.get(myIndex).getKey()!=SyntaxType.GROUPEND){
					myIndex++;
				}
				myIndex++;
			}catch(ArrayIndexOutOfBoundsException e){
				throw new SyntaxException("Miss a right brace ) in "+root.getName());
			}
			return;
		}
		
	}
	
	private void parseDoTimes(Node root) throws SyntaxException{
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Miss a left brace [ in " + root.getName());
			}
			else {
				myIndex++;
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.VARIABLE){
					throw new SyntaxException("Incompatible argument list in " + root.getName() + ", should be variable");
				}
				Node c=growTree();
				root.addChild(c);
				c=growTree();
				root.addChild(c);
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTEND){
					throw new SyntaxException("Miss a right brace ] in " + root.getName());
				}
				myIndex++;
			}	
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else {
				myListLegal=true;
				Node c=growTree();
				root.addChild(c);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseFor(Node root) throws SyntaxException{
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Miss a left brace [ in " + root.getName());
			}
			else {
				myIndex++;
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.VARIABLE){
					throw new SyntaxException("Incompatible argument list in " + root.getName() + ", should be variable");
				}
				Node c=null;
				for(int i=0;i<4;i++){
					c=growTree();
					root.addChild(c);
				}
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTEND){
					throw new SyntaxException("Miss a right brace ] in " + root.getName());
				}
				myIndex++;
			}	
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else {
				myListLegal=true;
				Node c=growTree();
				root.addChild(c);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseIfelse(Node root) throws SyntaxException{
		try {
			Node c = growTree();
			root.addChild(c);
			for (int i=0;i<2;i++) {
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
					throw new SyntaxException("Incompatible argument list in " + root.getName());
				}
				else {
					myListLegal=true;
					c=growTree();
					root.addChild(c);
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}

	private void parseIf(Node root) throws SyntaxException{
		try {
			Node c = growTree();
			root.addChild(c);
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else {
				myListLegal=true;
				c=growTree();
				root.addChild(c);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseTell(Node root) throws SyntaxException{
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Miss a left brace [ in " + root.getName());
			}
			else {
				myListLegal=true;
				Node c=growTree();
				root.addChild(c);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseAsk(Node root) throws SyntaxException{
		try{
			for(int i=0;i<2;i++){
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
					throw new SyntaxException("Miss a left brace [ in " + root.getName());
				}
				else {
					myListLegal=true;
					Node c=growTree();
					root.addChild(c);
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
	}
	
	private void parseMakeCmd(Node root) throws SyntaxException{
		int beginIndex=myIndex;
		root.setName(mySyntaxList.get(myIndex).getValue());
		myIndex++;
		try{
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Miss a left brace [ in " + root.getName());
			}
			else {
				myIndex++;
				while(mySyntaxList.get(myIndex).getKey()==SyntaxType.VARIABLE){
					Node c = growTree();
					root.addChild(c);
				}
				if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTEND){
					throw new SyntaxException("Miss a right brace ] in " + root.getName());
				}
				myIndex++;
			}	
			if(mySyntaxList.get(myIndex).getKey()!=SyntaxType.LISTSTART){
				throw new SyntaxException("Incompatible argument list in " + root.getName());
			}
			else {
				/*unsafe code, because the display string is empty for the time being*/
				myManiControl.setCommand(root.getName(), root);
//				myManiControl.setCommandOnly(root.getName(), root);
				myListLegal=true;
				Node c=growTree();
				root.addChild(c);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			throw new SyntaxException("Uncompleted argument list in " + root.getName());
		}
		int endIndex = myIndex;
		String display = null;
		for(int i=beginIndex;i<endIndex;i++){
			display.concat(mySyntaxList.get(i).getValue());
			display=display+" ";
		}
		/*unsafe code, because it will overwrite the previous prototype in the map*/
		myManiControl.setCommand(display, root.getName(), root);
//		myManiControl.setCommandWithDisplay(display, root.getName(), root);
	}
	
	//The following two methods are only used when we first create a parser. They will generate myTokenPatterns, mySyntaxPatterns
	public static List<Entry<TokenType, Pattern>> makeTokenPatterns (String fileName) {
        ResourceBundle resources = ResourceBundle.getBundle(fileName);
        List<Entry<TokenType, Pattern>> patterns = new ArrayList<Entry<TokenType, Pattern>>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<TokenType, Pattern>(tokenMap.get(key.toUpperCase()),
                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }
	
	//how to reduce redundancy? enum can't be extended
	public static Map<LangType,List<Entry<SyntaxType, Pattern>>> makeSyntaxPatterns () {
		Map<LangType,List<Entry<SyntaxType, Pattern>>> result= new HashMap<LangType,List<Entry<SyntaxType, Pattern>>>();
		String fileName;
		for(LangType each:LangType.values())
		{
			fileName="resources/languages/"+each.name().toLowerCase();
			ResourceBundle resources = ResourceBundle.getBundle(fileName);
	        List<Entry<SyntaxType, Pattern>> patterns = new ArrayList<Entry<SyntaxType, Pattern>>();
	        Enumeration<String> iter = resources.getKeys();
	        while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            String regex = resources.getString(key);
	            patterns.add(new SimpleEntry<SyntaxType, Pattern>(syntaxMap.get(key.toUpperCase()),
	                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
	        }
	        result.put(each, patterns);
		}
        return result;
    }
	
//	public static void main (String[] args) {
//		ManipulateController mani = new ManipulateController(new Workspace());
//		Executor exec = new Executor(mani);
//        Parser parser = new Parser(exec, mani);
//        parser.parse("make :r 4", "English");
//        System.out.println("11");
//    }

	@Override
	public void update(Observable o, Object arg) throws SyntaxException{
		init();
		UserInputTransferObject dto = (UserInputTransferObject) arg;
		String input = dto.getUserInput();
		System.out.println("Wanning"+input);
		String lang = dto.getLanguage();
		Response s = parse(input, lang);
		if (s instanceof Error)
			throw new SyntaxException(s.toString());
	}
}

