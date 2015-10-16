package backend.parser;

public enum SyntaxType {
//	#
//	# Turtle Commands
//	#
	FORWARD,
	BACKWARD,
	LEFT,
	RIGHT,
	SETHEADING,
	SETTOWARDS,
	SETPOSITION,
	PENDOWN,
	PENUP,
	SHOWTURTLE,
	HIDETURTLE,
	HOME,
	CLEARSCREEN,
//	#
//	# Turtle Queries
//	#
	XCOORDINATE,
	YCOORDINATE,
	HEADING,
	ISPENDOWN,
	ISSHOWING,
//	#
//	# Math Operations
//	#
	SUM,
	DIFFERENCE,
	PRODUCT,
	QUOTIENT,
	REMAINDER,
	MINUS,
	RANDOM,
	SINE,
	COSINE,
	TANGENT,
	ARCTANGENT,
	NATURALLOG,
	POWER,
	PI,
//	#
//	# Boolean Operations
//	#
	LESSTHAN,
	GREATERTHAN,
	EQUAL,
	NOTEQUAL,
	AND,
	OR,
	NOT,
//	#
//	# Variables, Control, and User-Defined Commands
//	#
	MAKEVARIABLE,
	REPEAT,
	DOTIMES,
	FOR,
	IF,
	IFELSE,
	MAKEUSERINSTRUCTION,
//	#
//	# Display Commands
//	#
	SETBACKGROUND,
	SETPENCOLOR,
	SETPENSIZE,
	SETSHAPE,
	SETPALETTE,
	GETPENCOLOR,
	GETSHAPE,
	STAMP,
	CLEARSTAMPS,
//	#
//	# Multiple Turtle Commands
//	#
	ID,
	TURTLES,
	TELL,
	ASK,
	ASKWITH;
}
