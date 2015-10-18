package sharedobjects;

import backend.node.Node;
import responses.Response;

public interface IWorkSpaceController {

	//constant declarations 
	
	//methods signatures
	
	//moves turtle forward in its current heading by 'pixels' distance
	Response foward(int pixels);
	
	//moves turtle backwards in its current heading by 'pixels' distance
	Response back(int pixels);
	
	//turns turtle ccw by 'degrees' angle
	Response left(double degrees);
	
	//turns turtle cw by 'degrees' angle
	Response right(double degrees);
	
	//turns turtle to an absolute heading
	Response setHeading(double degrees);
	
	//turns turtle to face point (x,y),
	//where (0,0) is the center of the screen
	Response towards(int x, int y);
	
	//moves the turtle to an absolute screen position, 
	//where (0,0) is the center of the screen
	Response setXY(int x, int y);
	
	//puts pen down such that when the turtle moves, 
	//it leaves a trail
	Response penDown();
	
	//puts pen up such that when the turtle moves, 
	//it leaves no trail
	Response penUp();
	
	//makes turtle visible
	Response showTurtle();
	
	//makes turtle invisible
	Response hideTurtle();
	
	//moves turtle to the center of the screen (0,0)
	//from logan: please include the amount moved by the turtle in this response object!
	Response home();
	
	//erases turtle's trails and sends it to the home position
	Response clearScreen();
	
	//add userDefinedCommand to Map
	Response setCommand(String s, Node n);
	
	//get userDefinedCommand from Map
	Node getCommand(String commandName);
		
	//add to Variables Map
	Response setVariable(String variableName, Node var);
	
	//get previously set Variables from Map
	Node getVariable(String variableName);
	
}
