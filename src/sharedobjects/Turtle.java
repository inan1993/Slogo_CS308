package sharedobjects;

import java.util.Observable;

public class Turtle extends Observable{
	private int ID;
	private double[] position;
	private double[] oldPosition;
	private double heading;
	private boolean penDown;
	private boolean showing;
	private boolean active;
	
	public Turtle(int id){
		ID = id;
		position = new double[]{0.0,0.0};
		oldPosition = new double[]{0.0,0.0};;
		heading = 90;
		penDown = true;
		showing = true;
		active = true;
		this.setChanged();
	}
<<<<<<< HEAD
	
//	public Turtle(double[] pos){
//		position = pos;
//		oldPosition = pos;
//	}
=======
>>>>>>> master

	public void setID(int i){
		ID = i;
		this.setChanged();
	}
	
	public int getID(){
		return ID;
	}
	
	public void setPosition(double[] p){
	        oldPosition = position;
	        position = p;
		System.out.println("Changing the current Turtle's position to..." + p[0] + ":" + p[1]);
		this.setChanged();
	}
	
	public double[] getPosition(){
		return position;
	}
	
	public double[] getOldPosition(){
            return oldPosition;
        }

	public void setHeading(double h){
		heading = h;
	}
	
	public double getHeading(){
		return heading;
	}
	
	public void penUp(){
		penDown = false;
		this.setChanged();
	}
	
	public void penDown(){
		this.setChanged();
		penDown = true;
	}
	
	public boolean isPenDown(){
		return penDown;
	}
	
	public void show(){
		this.setChanged();
		showing = true;
	}
	
	public void hide(){
		this.setChanged();
		showing = false;
	}
	
	public boolean isShowing(){
		return showing;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void activate(){
		active = true;
	}
	
	public void deativate(){
		active = false;
	}
}
