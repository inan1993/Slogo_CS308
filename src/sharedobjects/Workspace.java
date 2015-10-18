package sharedobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import backend.node.Node;
import datatransferobjects.TurtleTransferObject;

public class Workspace {

	List<Turtle> turtleList;
	List<Pen> penList;
	Map<String, Node> commandMap;
	Map<String, Node> variableMap;
	Turtle currTurtle;
	
	public Workspace() {
		turtleList = new LinkedList<Turtle>();
		penList = new LinkedList<Pen>();
		currTurtle = new Turtle();
		turtleList.add(currTurtle);
		commandMap = new HashMap<String, Node>();
		variableMap = new HashMap<String, Node>();
	}
	
	public void setHeading(double angle){
		currTurtle.setHeading(angle);
	}
	
	public double getHeading(){
		return currTurtle.getHeading();
	}
	
	public void setPosition(int[] pos){
		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), false, currTurtle.isPenDown(), currTurtle.getPosition(), pos);
		currTurtle.setPosition(pos);
		currTurtle.notifyObservers(dto);
	}
	
	public int[] getPosition(){
		return currTurtle.getPosition();
	}
	
	public void showTurtle(){
		currTurtle.show();
		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), true, currTurtle.isPenDown(), currTurtle.getPosition(), currTurtle.getPosition());
		currTurtle.notifyObservers(dto);
	}
	
	public void hideTurtle(){
		currTurtle.hide();
		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), false, currTurtle.isPenDown(), currTurtle.getPosition(), currTurtle.getPosition());
		currTurtle.notifyObservers(dto);
	}
	
 	//****Pen Manipulation********
	public void penUp(){
		currTurtle.penUp();
	}
	
	public void penDown(){
		currTurtle.penDown();
	}
	
	//****Commands and Variables Manipulation*****//
	public void addVariable(String v, Node n){
		variableMap.put(v, n);
	}
	
	public Node getVariable(String v){
		return variableMap.get(v);
	}
	
	public void addCommand(String c, Node n){
		commandMap.put(c, n);
	}
	
	public Node getCommand(String c){
		return commandMap.get(c);
	}
	
	public List<Observable> getObservables(){
		List<Observable> observables = new LinkedList<Observable>();
		for(Turtle t: turtleList){
			observables.add((Observable) t);
		}
		return observables;
	}
	
}
