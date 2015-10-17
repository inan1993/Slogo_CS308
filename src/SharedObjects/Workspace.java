package sharedobjects;

import java.util.LinkedList;
import java.util.List;

import datatransferobjects.TurtleTransferObject;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class Workspace {

	List<Turtle> turtleList;
	List<Pen> penList;
	List<Object> variableList;
	Turtle currTurtle;
	
	public Workspace() {
		turtleList = new LinkedList<Turtle>();
		penList = new LinkedList<Pen>();
		variableList = new LinkedList<Object>();
	}
	
	
	//****Turtle Manipulation********
	public void addTurtle(Turtle T){
		//set up different kinds of inputs to feed into Turtle constructor 
		//if only sending position... or position + color... position + angle+color 
		//...etc
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
	
}
