package GUI.TurtlePane;

import java.util.ResourceBundle;

import GUI.SlogoModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TurtlePane extends Canvas{
    
    //private SlogoModel mySlogoModel;
    private Turtle myTurtle;
    private GraphicsContext gc;
    private static final String TURTLE_RESOURCE_PACKAGE = "GUI.TurtlePane/default";
    protected static ResourceBundle myResource;

    public TurtlePane (int width, int height) {
        super(width, height);
        myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

        gc = this.getGraphicsContext2D(); 
        gc.setFill(Color.valueOf(myResource.getString("backgroundColors")));
        gc.fillRect(0,0,width,height);
        myTurtle = new Turtle();
        drawTurtle();
    }

    private void drawTurtle(){
    	gc.drawImage(myTurtle.getMyTurtle(), getWidth()/2, getHeight()/2);
    }
}
