package sharedobjects;

import java.util.Observable;
import java.util.Random;

public class Turtle extends Observable{
	private int ID;
	private int[] position;
	private double heading;
	private boolean penDown;
	private boolean showing;
	
	private Random rand = new Random();
	
	public Turtle(){
		ID = rand.nextInt(100000) + 1;
		position = new int[]{0,0};
		heading = 90;
		penDown = true;
		showing = true;
	}
	
	public Turtle(int[] pos){
		position = pos;
	}

	public void setID(int i){
		ID = i;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setPosition(int[] p){
		position = p;
	}
	
	public int[] getPosition(){
		return position;
	}

	public void setHeading(double h){
		heading = h;
	}
	
	public double getHeading(){
		return heading;
	}
	
	public void penUp(){
		penDown = false;
	}
	
	public void penDown(){
		penDown = true;
	}
	
	public boolean isPenDown(){
		return penDown;
	}
	
	public void show(){
		showing = true;
	}
	
	public void hide(){
		showing = false;
	}
	
	public boolean isShowing(){
		return showing;
	}
}
