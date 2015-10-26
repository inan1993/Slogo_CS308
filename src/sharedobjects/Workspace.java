package sharedobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import backend.node.Node;
import datatransferobjects.TurtleTransferObject;
import datatransferobjects.ParsedCommandsTransferObject;

public class Workspace {

	Map<Integer, Turtle> allTurtles;
	List<Turtle> activeTurtles;
	List<Turtle> tempTurtles;
	ParsedCommands userInputsObservable = new ParsedCommands();
	Pen pen;
	
	public Workspace() {
		allTurtles = new HashMap<Integer, Turtle>();
		allTurtles.put(1, new Turtle(1));
		activeTurtles = new LinkedList<Turtle>();
		activeTurtles.add(allTurtles.get(1));
		tempTurtles = new LinkedList<Turtle>();
		pen = new Pen();
	}
	
	public Turtle addNewTurtle(int id){
		Turtle turt = new Turtle(id);
		allTurtles.put(id, turt);
		return turt;
	}
	
	public Map<Integer, Turtle> getAllTurtles(){
		return allTurtles;
	}
	
	public List<Turtle> getActiveTurtles() {
		return activeTurtles;
	}
	
	public void setActiveTurtles(List<Turtle> activeTurtles) {
		this.activeTurtles = activeTurtles;
	}
	
	public void setTempTurtles(List<Turtle> tempTurtles){
		this.tempTurtles = tempTurtles;
	}
	
	public List<Turtle> getTempTurtles(){
		return tempTurtles;
	}
	
//	public void setHeading(double angle){
//		currTurtle.setHeading(angle);
//	}
//	
//	public double getHeading(){
//		return currTurtle.getHeading();
//	}
//	
//	public void setPosition(int[] pos){
//		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), false, currTurtle.isPenDown(), currTurtle.getPosition(), pos);
//		currTurtle.setPosition(pos);
//		currTurtle.notifyObservers(dto);
//	}
//	
//	public int[] getPosition(){
//		return currTurtle.getPosition();
//	}
//	
//	public void showTurtle(){
//		currTurtle.show();
//		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), true, currTurtle.isPenDown(), currTurtle.getPosition(), currTurtle.getPosition());
//		currTurtle.notifyObservers(dto);
//	}
//	
//	public void hideTurtle(){
//		currTurtle.hide();
//		TurtleTransferObject dto = new TurtleTransferObject(false, currTurtle.getID(), false, currTurtle.isPenDown(), currTurtle.getPosition(), currTurtle.getPosition());
//		currTurtle.notifyObservers(dto);
//	}
//	
// 	//****Pen Manipulation********
//	public void penUp(){
//		currTurtle.penUp();
//	}
//	
//	public void penDown(){
//		currTurtle.penDown();
//	}
	
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
	
	public void addCommand(String c, Node n){
		userInputsObservable.addCommand(c, n);
	}
	
	public Node getCommand(String c){
		return userInputsObservable.getCommand(c);
	}
	
	public List<Observable> getObservables(){
		List<Observable> observables = new LinkedList<Observable>();
		for(Turtle t: activeTurtles){
		        System.out.println("here2");
			observables.add((Observable) t);
		}
		observables.add(userInputsObservable);
		return observables;
	}
	
	public void startWorkspace(){
		Turtle firstTurtle = activeTurtles.get(0);
		TurtleTransferObject dto = new TurtleTransferObject(false, firstTurtle.getID(), false, true, new int[]{12,12}, new int[]{12,12});
		firstTurtle.notifyObservers(dto);
		System.out.println("here1");
	}
	
}