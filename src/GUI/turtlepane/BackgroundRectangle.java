package GUI.turtlepane;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sharedobjects.DisplayProperties;
import sharedobjects.Turtle;

public class BackgroundRectangle extends Rectangle implements Observer{

	private static final String TURTLE_RESOURCE_PACKAGE = "GUI.turtlepane/default";
	protected static ResourceBundle myResource;

	private Color myBackgroundColor;
	
	public BackgroundRectangle() {
		super(Integer.parseInt(myResource.getString("canvasWidth")), Integer.parseInt(myResource.getString("canvasHeight")));
	}
	
	public BackgroundRectangle (int width, int height) {
		super(width, height);
		myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);
		myBackgroundColor = Color.valueOf(myResource.getString("backgroundColors"));
		this.setFill(myBackgroundColor);
	}

	public void setBackgroundColor(String color){
		this.myBackgroundColor = Color.valueOf(color);
		this.setFill(myBackgroundColor);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (((String) arg).equals("turtle")) {
			DisplayProperties t = (DisplayProperties) o;
			this.setFill(t.getBgColor());
		} else if (((String) arg).equals("bg")) {
			DisplayProperties t = (DisplayProperties) o;
			setBackgroundColor(t.getBgColor().toString());
		}
	}
}


