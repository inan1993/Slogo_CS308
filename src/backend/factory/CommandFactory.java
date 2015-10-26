package backend.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import backend.node.Node;
import backend.node.commands.*;
import backend.node.control.*;
import backend.node.operations.*;
import backend.node.types.Constant;
import backend.node.control.Variable;
import backend.node.display.*;
import backend.parser.SyntaxType;

public class CommandFactory {
	private static HashMap<SyntaxType, Class> myRegisteredCommands = new HashMap<SyntaxType, Class>();

	static {
		//// #
		//// # Turtle Commands
		//// #
		registerNode(SyntaxType.FORWARD, FD.class);
		registerNode(SyntaxType.BACKWARD, BK.class);
		registerNode(SyntaxType.LEFT, LT.class);
		registerNode(SyntaxType.RIGHT, RT.class);
		registerNode(SyntaxType.SETHEADING, SETH.class);
		registerNode(SyntaxType.SETTOWARDS, TOWARDS.class);
		registerNode(SyntaxType.SETPOSITION, GOTO.class);
		registerNode(SyntaxType.PENDOWN, PD.class);
		registerNode(SyntaxType.PENUP, PU.class);
		registerNode(SyntaxType.SHOWTURTLE, ST.class);
		registerNode(SyntaxType.HIDETURTLE, HT.class);
		registerNode(SyntaxType.HOME, HOME.class);
		registerNode(SyntaxType.CLEARSCREEN, CS.class);
		
		//// #
		//// # Turtle Queries
		//// #
		// XCOORDINATE,
		// YCOORDINATE,
		// HEADING,
		// ISPENDOWN,
		// ISSHOWING,
		//// #
		//// # Math Operations
		//// #
		registerNode(SyntaxType.SUM, SUM.class);
		registerNode(SyntaxType.DIFFERENCE, DIFFERENCE.class);
		registerNode(SyntaxType.PRODUCT, PRODUCT.class);
		registerNode(SyntaxType.QUOTIENT, QUOTIENT.class);
		registerNode(SyntaxType.REMAINDER, REMAINDER.class);
		registerNode(SyntaxType.MINUS, MINUS.class);
		registerNode(SyntaxType.RANDOM, RANDOM.class);
		registerNode(SyntaxType.SINE, SIN.class);
		registerNode(SyntaxType.COSINE, COS.class);
		registerNode(SyntaxType.TANGENT, TAN.class);
		registerNode(SyntaxType.ARCTANGENT, ATAN.class);
		registerNode(SyntaxType.NATURALLOG, LOG.class);
		registerNode(SyntaxType.POWER, POW.class);
		registerNode(SyntaxType.PI, PI.class);
		//// #
		//// # Boolean Operations
		//// #
		registerNode(SyntaxType.LESSTHAN, LESSP.class);
		registerNode(SyntaxType.GREATERTHAN, GREATERP.class);
		registerNode(SyntaxType.EQUAL, EQUALP.class);
		registerNode(SyntaxType.NOTEQUAL, NOTEQUALP.class);
		registerNode(SyntaxType.AND, AND.class);
		registerNode(SyntaxType.OR, OR.class);
		registerNode(SyntaxType.NOT, NOT.class);
		//// #
		//// # Variables, Control, and User-Defined Commands
		//// #
		registerNode(SyntaxType.MAKEVARIABLE, MAKEVAR.class);
		registerNode(SyntaxType.REPEAT, REPEAT.class);
		registerNode(SyntaxType.DOTIMES, DOTIMES.class);
		registerNode(SyntaxType.FOR, FOR.class);
		registerNode(SyntaxType.IF, IF.class);
		registerNode(SyntaxType.IFELSE, IFELSE.class);
		registerNode(SyntaxType.MAKEUSERINSTRUCTION, TOCOMMAND.class);
		//// #
		//// # Display Commands
		//// #
		registerNode(SyntaxType.SETBACKGROUND, SETBG.class);
		registerNode(SyntaxType.SETPENCOLOR, SETPC.class);
		registerNode(SyntaxType.SETPENSIZE, SETPS.class);
		registerNode(SyntaxType.SETSHAPE, SETSH.class);
		registerNode(SyntaxType.SETPALETTE, SETPALETTE.class);
		registerNode(SyntaxType.GETPENCOLOR, PC.class);
		registerNode(SyntaxType.GETSHAPE, SH.class);
		registerNode(SyntaxType.STAMP, STAMP.class);
		registerNode(SyntaxType.CLEARSTAMP, CLEARSTAMP.class);
		registerNode(SyntaxType.CLEARSCREEN, CS.class);
		//// #
		//// # Multiple Turtle Commands
		//// #
		registerNode(SyntaxType.ID, ID.class);
		registerNode(SyntaxType.TURTLES, TURTLES.class);
		registerNode(SyntaxType.TELL, TELL.class);
		registerNode(SyntaxType.ASK, ASK.class);
		registerNode(SyntaxType.ASKWITH, ASKWITH.class);
		//// #
		//// # Non-Command
		//// #
		registerNode(SyntaxType.VARIABLE, Variable.class);
		registerNode(SyntaxType.CONSTANT, Constant.class);
		registerNode(SyntaxType.LISTSTART, LISTSTART.class);
		// LISTEND,
		registerNode(SyntaxType.GROUPSTART, GROUPSTART.class);// GROUPSTART,
		// GROUPEND,
		registerNode(SyntaxType.USERCOMMAND, USERCOMMAND.class);
	}

	public static void registerNode(SyntaxType type, Class nodeClass) {
		myRegisteredCommands.put(type, nodeClass);
	}

	public Node createNode(SyntaxType type) {
		Node result = null;
		int a = myRegisteredCommands.size();
		Class nodeClass = (Class) myRegisteredCommands.get(type);
		Constructor nodeConstructor = null;
		try {
			nodeConstructor = nodeClass.getDeclaredConstructor(new Class[] {});
			result = (Node) nodeConstructor.newInstance();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
