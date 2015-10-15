package SharedObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends ImageView {
	private Image turtleImage;
	private int ID;
	private int[] position;
	private double heading;
	private boolean penDown;
	private boolean showing;
	

	public Turtle(){
		Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
		turtleImage = turtle;
	}
	
	public Image getTurtleImage() {
		return turtleImage;
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
	
	public void changePenDown(){
		penDown = !penDown;
	}
	
	public boolean isPenDown(){
		return penDown;
	}
	
	public void changeIsShowing(){
		showing = !showing;
	}
	
	public boolean isShowing(){
		return showing;
	}
	
	
}
