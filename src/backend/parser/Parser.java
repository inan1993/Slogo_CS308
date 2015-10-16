package backend.parser;

import responses.Response;
import responses.Error;
import backend.*;
import backend.executor.Executor;
import backend.factory.NodeFactory;
import backend.node.Node;

import java.util.List;
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
	private Executor exec;
	private List<Node> myRoots;
	private Response myResponse;
	private static final HashMap<String, TokenType> tokenMap = new HashMap<String, TokenType>(){{
		for(TokenType each:TokenType.values())
		{
			tokenMap.put(each.name().toUpperCase(), each);
		}
	}};
	private static final HashMap<String, SyntaxType> syntaxMap = new HashMap<String, SyntaxType>(){{
		for(SyntaxType each:SyntaxType.values())
		{
			syntaxMap.put(each.name().toUpperCase(), each);
		}
	}};
	
	public Parser() {
		//Call run to start.
		exec = new Executor();
		myRoots = new ArrayList<Node>();
		myResponse = new Error("Haven't begin parsing");
	}
	
	
	public Response parse(String userInput) {
		BufferedReader reader=new BufferedReader(new StringReader(userInput));
		String line;
		try {
			while((line=reader.readLine())!=null)
			{
				buildSyntaxTree(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Node each:myRoots)
		{
			myResponse=exec.execute(each);
		}
		return myResponse;
	}
	
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
	public static List<Entry<SyntaxType, Pattern>> makeSyntaxPatterns (String fileName) {
        ResourceBundle resources = ResourceBundle.getBundle(fileName);
        List<Entry<SyntaxType, Pattern>> patterns = new ArrayList<Entry<SyntaxType, Pattern>>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<SyntaxType, Pattern>(syntaxMap.get(key.toUpperCase()),
                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }
	
	
	private static boolean match (String input, Pattern regex) {
        return regex.matcher(input).matches();
    }
	
	private List<Entry<TokenType, String>> generateToken(String line) throws LexiconException {
		List<Entry<TokenType, String>> result = new ArrayList<Entry<TokenType, String>>();
		List<Entry<TokenType, Pattern>> patterns = makeTokenPatterns("Syntax.properties");
		StringTokenizer st=new StringTokenizer(line," ");
		String nodeName;
		boolean matchFlag=false;
		while (st.hasMoreTokens())
		{
			nodeName=st.nextToken();
			for(Entry<TokenType, Pattern> p:patterns)
			{
				if(match(nodeName, p.getValue()))
				{
					result.add(new SimpleEntry<TokenType, String>(p.getKey(), nodeName));
					matchFlag=true;
					break;
				}
			}
			if(!matchFlag) throw new LexiconException("Ilegal Input: Cannot find a matching token!");
		}
		return result;	
	}
	
	private void buildSyntaxTree(String line){
		List<Entry<TokenType, String>> tokenList=null;
		try {
			tokenList = generateToken(line);
		} catch (LexiconException e) {
			myResponse=new Error(e.getMessage());
		}
		Integer index=0;
		while(index<tokenList.size()){
			Node root=growTree(tokenList,index);
			myRoots.add(root);
		}
	}
	
	private Node growTree(List<Entry<TokenType, String>> tokenList, Integer index){
		NodeFactory factory = new NodeFactory();
		Node root = factory.createNode(tokenList.get(index).getValue());
		int numOfChildren=root.getChildrenNum();
		for(int i=0;i<numOfChildren;i++)
		{
			index++;
			root.addChild(factory.createNode(tokenList.get(index).getValue()));
		}
		return root;
	}
	
}
