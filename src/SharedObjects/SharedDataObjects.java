package SharedObjects;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

public class SharedDataObjects {

	List<Turtle> turtleList;
	List<Pen> penList;
	List<Object> variableList;
	Turtle currTurtle;
	
	public SharedDataObjects() {
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
	
	public void setImage(Image i){
		currTurtle.setImage(i);
	}
	
	public void setHeading(double angle){
		currTurtle.setHeading(angle);
	}
	
	public double getHeading(){
		return currTurtle.getHeading();
	}
	
	public void setPosition(int[] pos){
		currTurtle.setPosition(pos);
	}
	
	public int[] getPosition(){
		return currTurtle.getPosition();
	}
	
	public void showTurtle(){
		currTurtle.show();
	}
	
	public void hideTurtle(){
		currTurtle.hide();
	}
	
 	//****Pen Manipulation********
	public void penUp(){
		currTurtle.penUp();
	}
	
	public void penDown(){
		currTurtle.penDown();
	}
	
}
