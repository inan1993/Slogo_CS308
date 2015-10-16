package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map.Entry;

import backend.parser.*;

import backend.node.*;

public class NodeFactory {
	private static HashMap<String,Class> myRegisteredNodes = new HashMap<String,Class>();

	public void registerNode (String nodeText, Class nodeClass)
	{
		myRegisteredNodes.put(nodeText, nodeClass);
	}

//	public Node createNode(String nodeText)
	public Node createNode(Entry<TokenType, String> token)
	{
		Node result=null;
		switch(token.getKey()){
		case COMMENT:
		case CONSTANT:
		case VARIABLE:
			result = new Variable(token.getValue().substring(1));
		case COMMAND:
			Class nodeClass = (Class)myRegisteredNodes.get(token.getValue());
			Constructor nodeConstructor;
			try {
				nodeConstructor = nodeClass.getDeclaredConstructor(new Class[] { String.class });
				result = (Node) nodeConstructor.newInstance(new Object[] { });
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		case LISTSTART:
		case LISTEND:
		case GROUPSTART:
		case GROUPEND:
			
		}
		return null;
	}
}
