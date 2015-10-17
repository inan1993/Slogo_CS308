package backend.parser;

import responses.Response;
import responses.Error;
import backend.*;
import backend.node.Executor;
import backend.factory.NodeFactory;
import backend.node.Node;
import resources.languages.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.AbstractMap.SimpleEntry;


/**
 * @author wanning
 *
 */
public class Parser {
	private Executor myExec;
	private List<Node> myRoots;
	private int myIndex;
	private String myLanguage = "English";
	private List<Entry<TokenType, String>> myTokenList; 
	private static final HashMap<String, TokenType> tokenMap = new HashMap<String, TokenType>(){{
		for(TokenType each:TokenType.values())
		{
			put(each.name(), each);
		}
	}};
	private static final HashMap<String, SyntaxType> syntaxMap = new HashMap<String, SyntaxType>(){{
		for(SyntaxType each:SyntaxType.values())
		{
			put(each.name(), each);
		}
	}};
	private static final HashMap<String, LangType> languageMap = new HashMap<String, LangType>(){{
		for(LangType each:LangType.values())
		{
			put(each.name(), each);
		}
	}};

	private static final List<Entry<TokenType, Pattern>> myTokenPatterns = makeTokenPatterns("resources/languages/Syntax");
	public static final Map<LangType,List<Entry<SyntaxType, Pattern>>> mySyntaxPatterns = makeSyntaxPatterns();
	
	public Parser() {
		//Call run to start.
		myExec = new Executor();
		myRoots = new ArrayList<Node>();
		myIndex=0;
	}
	
	public Response parse(String userInput) {
		myTokenList=new ArrayList<Entry<TokenType, String>>();
		Response response = new Error("Haven't begin parsing");
		BufferedReader reader=new BufferedReader(new StringReader(userInput));
		String line;
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
		try {
			buildSyntaxTree();
		} catch (SyntaxException e)
		{
			response=new Error(e.getMessage());
			return response;
		}
		for(Node each:myRoots)
		{
//			should add a try catch, and make executor throws execute exception
			myExec.execute(each);
		}
		return response;
	}
		
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
					result.add(new SimpleEntry<TokenType, String>(p.getKey(), nodeName));
					matchFlag=true;
					if(p.getKey()==TokenType.COMMENT)
					{
						commentFlag=true;
					}
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
		while(myIndex<myTokenList.size()){
			Node root=null;
			root=growTree(myTokenList); 
			if(root!=null){
				myRoots.add(root);
			}
			myIndex++;
		}
	}
	
	private Node growTree(List<Entry<TokenType, String>> tokenList) throws SyntaxException{
		NodeFactory factory = new NodeFactory();
		Node root = factory.createNode(tokenList.get(myIndex), languageMap.get(myLanguage.toUpperCase()));
		int numOfChildren=root.getChildrenNum();
		int i=0;
		while(i<numOfChildren)
		{
			myIndex++;
			Node c = growTree(tokenList);
			root.addChild(c);
			i++;
		}
		return root;
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
	
	public static void main (String[] args) {
        Parser parser = new Parser();
        parser.parse("forward 50");
        System.out.println("11");
    }
}
