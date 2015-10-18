package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import backend.node.Constant;
import backend.node.Node;
import backend.node.commands.*;
import backend.node.control.*;
import backend.parser.SyntaxType;

public class NodeFactory {
	private static HashMap<SyntaxType,Class> myRegisteredCommands = new HashMap<SyntaxType,Class>();
	
	static{
		registerCmd(SyntaxType.BACKWARD, BK.class);
		registerCmd(SyntaxType.FORWARD, FW.class);
		registerCmd(SyntaxType.DOTIMES, DoTimes.class);
		registerCmd(SyntaxType.CONSTANT,Constant.class);
		registerCmd(SyntaxType.REPEAT, Repeat.class);
		registerCmd(SyntaxType.LISTSTART, ListStart.class);
	}

	public static void registerCmd (SyntaxType type, Class nodeClass)
	{
		myRegisteredCommands.put(type, nodeClass);
	}

	public Node createNode(SyntaxType type)
	{
		Node result=null;
		Class nodeClass = (Class)myRegisteredCommands.get(type);
		Constructor nodeConstructor;
		try {
			nodeConstructor = nodeClass.getDeclaredConstructor(new Class[]{});
			result = (Node) nodeConstructor.newInstance();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
