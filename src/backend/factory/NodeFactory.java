package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;


import backend.parser.*;
import backend.node.Constant;
import backend.node.Node;
import backend.node.Variable;

public class NodeFactory {
	public Node createNode(Entry<TokenType, String> entry, LangType language)
	{
		Node result=null;
		switch(entry.getKey()){
		case COMMENT:
			System.out.println("did not detected comment successfully in token parsing");
			break;
		case CONSTANT:
			result = new Constant(entry.getValue());
			break;
		case VARIABLE:
			result = new Variable(entry.getValue().substring(1));
			break;
		case COMMAND:
			CommandFactory factory = new CommandFactory();
			for(Entry<SyntaxType, Pattern> p:Parser.mySyntaxPatterns.get(language))
			{
				if(Parser.match(entry.getValue(), p.getValue()))
				{
					result = factory.createNode(p.getKey());
					result.setName(entry.getValue());
				}
			}
			break;
		case LISTSTART:
		case LISTEND:
		case GROUPSTART:
		case GROUPEND:			
		}
		return result;
	}
}
