package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import backend.node.Constant;
import backend.node.Node;
import backend.node.Variable;
import backend.parser.SyntaxType;

public class CommandFactory {
	private static HashMap<SyntaxType,Class> myRegisteredCommands = new HashMap<SyntaxType,Class>();

	public void registerNode (SyntaxType type, Class nodeClass)
	{
		myRegisteredCommands.put(type, nodeClass);
	}

	public Node createNode(SyntaxType type)
	{
		Node result=null;
		Class nodeClass = (Class)myRegisteredCommands.get(type);
		Constructor nodeConstructor;
		try {
			nodeConstructor = nodeClass.getDeclaredConstructor(new Class[] { String.class });
			result = (Node) nodeConstructor.newInstance(new Object[] { });
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
