package sharedobjects;

import java.util.ResourceBundle;

import exceptions.NotImplementedException;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Pen {

	private Paint color;
	private double thickness;
	private String state;

	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final String DEFAULT_RESOURCE_VIEW = "GUI.view";
    private static ResourceBundle myResource;
    private static final String DEFAULT_LANGUAGE = "English";
	
	public Pen() {
		ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + DEFAULT_LANGUAGE);
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_VIEW);
		color =  Paint.valueOf(myResource.getString("defaultPenColor"));
		thickness = Integer.parseInt(myResource.getString("defaultPenThickness"));
		state = myResource.getString("defaultPenState");
	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public Paint getColor(){
		return color;
	}
	
	public void setThickness(double t){
		thickness = t;
	}
	
	public double getThickness(){
		return thickness;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public void setShape() {
		throw new NotImplementedException();
	}

}
