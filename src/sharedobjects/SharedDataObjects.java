package sharedobjects;

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
	
	public void setColor(Turtle t, Paint p){
		
	}
	
	public void setShape(Turtle t, Shape s){
		
	}
	
	public void setImage(Turtle t, Image i){
		
	}
	
	public void setAngle(Turtle t, double angle){
		
	}
	
	public void setPosition(Turtle t, int[] pos){
		
	}
	
 	//****Pen Manipulation********
	public void removePen(Pen p){
		
	}
	
	public void addPen(Turtle t, Pen p){
		
	}
	
	public void addLine(Pen p, int[] pairs){
		//line 1 = (x1,y1),(x2,y2)
		//(pairs[0],pairs[1]), (pairs[3],pairs[4])

	}
	
	public void setColor(Pen p, Color c){
		
	}
	
	public void clearPen(Pen p){
		
	}	
	
}
