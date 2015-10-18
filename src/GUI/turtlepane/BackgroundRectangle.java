package GUI.turtlepane;

import java.util.ResourceBundle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackgroundRectangle extends Rectangle{

    private static final String TURTLE_RESOURCE_PACKAGE = "GUI.turtlepane/default";
    protected static ResourceBundle myResource;
    
    private Color myBackgroundColor;
    
    public BackgroundRectangle (int width, int height) {
        super(width, height);
        myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);
        myBackgroundColor = Color.valueOf(myResource.getString("backgroundColors"));
        System.out.println(myResource.getString("backgroundColors"));
        this.setFill(myBackgroundColor);
    }
    
    public void setBackgroundColor(String color){
        this.myBackgroundColor = Color.valueOf(color);
        this.setFill(myBackgroundColor);
    }

}
