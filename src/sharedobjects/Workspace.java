package sharedobjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import backend.node.Node;
import datatransferobjects.TurtleTransferObject;
import datatransferobjects.ParsedCommandsTransferObject;

public class Workspace {

	List<Turtle> turtleList;
	List<Pen> penList;
	Turtle currTurtle;
	ParsedCommands userInputsObservable = new ParsedCommands();
	
	public Workspace() {
		turtleList = new LinkedList<Turtle>();
		penList = new LinkedList<Pen>();
		currTurtle = new Turtle();
		turtleList.add(currTurtle);
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
		userInputsObservable.addVariable(v, n);
		ParsedCommandsTransferObject uito = new ParsedCommandsTransferObject(false, v + " = " + n.getDoubleValue());
		userInputsObservable.notifyObservers(uito);
	}
	
	public Node getVariable(String v){
		return userInputsObservable.getVariable(v);
	}
	
	public void addCommand(String userInput, String c, Node n){
		userInputsObservable.addCommand(c, n);
		ParsedCommandsTransferObject uito = new ParsedCommandsTransferObject(true, userInput);
		userInputsObservable.notifyObservers(uito);
	}
	
	public Node getCommand(String c){
		return userInputsObservable.getCommand(c);
	}
	
	public List<Observable> getObservables(){
		List<Observable> observables = new LinkedList<Observable>();
		for(Turtle t: turtleList){
		        System.out.println("here2");
			observables.add((Observable) t);
		}
		observables.add(userInputsObservable);
		return observables;
	}
	
	public void startWorkspace(){
		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), false, true, new int[]{12,12}, new int[]{12,12});
		currTurtle.notifyObservers(dto);
		System.out.println("here1");
	}
	
}
