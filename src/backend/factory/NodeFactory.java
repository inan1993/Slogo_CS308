package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import backend.node.Node;

public class NodeFactory {
	private static HashMap<String,Class> myRegisteredNodes = new HashMap<String,Class>();

	public void registerNode (String nodeText, Class nodeClass)
	{
		myRegisteredNodes.put(nodeText, nodeClass);
	}

	public Node createNode(String nodeText)
	{
		Class nodeClass = (Class)myRegisteredNodes.get(nodeText);
		Constructor nodeConstructor;
		try {
			nodeConstructor = nodeClass.getDeclaredConstructor(new Class[] { String.class });
			return (Node) nodeConstructor.newInstance(new Object[] { });
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
