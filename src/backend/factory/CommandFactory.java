package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import backend.node.Constant;
import backend.node.Node;
import backend.node.Variable;
import backend.node.commands.*;
import backend.node.control.*;
import backend.parser.SyntaxType;

public class CommandFactory {
	private static HashMap<SyntaxType,Class> myRegisteredCommands = new HashMap<SyntaxType,Class>();

	static{
////		#
////		# Turtle Commands
////		#
		registerNode(SyntaxType.FORWARD, FW.class);
//		BACKWARD,
//		LEFT,
//		RIGHT,
//		SETHEADING,
//		SETTOWARDS,
//		SETPOSITION,
//		PENDOWN,
//		PENUP,
//		SHOWTURTLE,
//		HIDETURTLE,
//		HOME,
//		CLEARSCREEN,
////		#
////		# Turtle Queries
////		#
//		XCOORDINATE,
//		YCOORDINATE,
//		HEADING,
//		ISPENDOWN,
//		ISSHOWING,
////		#
////		# Math Operations
////		#
//		SUM,
//		DIFFERENCE,
//		PRODUCT,
//		QUOTIENT,
//		REMAINDER,
//		MINUS,
//		RANDOM,
//		SINE,
//		COSINE,
//		TANGENT,
//		ARCTANGENT,
//		NATURALLOG,
//		POWER,
//		PI,
////		#
////		# Boolean Operations
////		#
//		LESSTHAN,
//		GREATERTHAN,
//		EQUAL,
//		NOTEQUAL,
//		AND,
//		OR,
//		NOT,
////		#
////		# Variables, Control, and User-Defined Commands
////		#
//		MAKEVARIABLE,
		registerNode(SyntaxType.REPEAT, Repeat.class);
		registerNode(SyntaxType.DOTIMES, DoTimes.class);
//		FOR,
//		IF,
//		IFELSE,
		registerNode(SyntaxType.MAKEUSERINSTRUCTION, ToCommand.class);
////		#
////		# Display Commands
////		#
//		SETBACKGROUND,
//		SETPENCOLOR,
//		SETPENSIZE,
//		SETSHAPE,
//		SETPALETTE,
//		GETPENCOLOR,
//		GETSHAPE,
//		STAMP,
//		CLEARSTAMPS,
////		#
////		# Multiple Turtle Commands
////		#
//		ID,
//		TURTLES,
//		TELL,
//		ASK,
//		ASKWITH,
////		#
////		# Non-Command
////		#
//		VARIABLE,
		registerNode(SyntaxType.CONSTANT,Constant.class);
		registerNode(SyntaxType.LISTSTART, ListStart.class);
//		LISTEND,
//		GROUPSTART,
//		GROUPEND,
//		USERCOMMAND;
	}
	
	public static void registerNode (SyntaxType type, Class nodeClass)
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
