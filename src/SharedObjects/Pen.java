package SharedObjects;

import javafx.scene.paint.Color;

public class Pen {
	
	private Color color;
	private double size;
	
	public Pen() {

	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setSize(double s){
		size = s;
	}
	
	public double getSize(){
		return size;
	}
	

}
