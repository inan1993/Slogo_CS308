package sharedobjects;

import java.util.ResourceBundle;

import exceptions.NotImplementedException;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Pen {

    private Color myColor;
    private double thickness;
    private String state;

    private static final String DEFAULT_GUI_RESOURCE = "GUI.view";
    private static ResourceBundle myResource;

    public Pen() {
        myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
        myColor =  Color.valueOf(myResource.getString("defaultPenColor"));
        thickness = Integer.parseInt(myResource.getString("defaultLineThickness"));
        state = myResource.getString("defaultLineType");
    }

    public void setColor(String color){
        myColor = Color.valueOf(color);
    }

    public Paint getColor(){
        return myColor;
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
