package GUI.turtlepane;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TurtlePane extends Canvas{
    
    //private SlogoModel mySlogoModel;
    private Turtle myTurtle;
    private GraphicsContext gc;
    private static final String TURTLE_RESOURCE_PACKAGE = "GUI.TurtlePane/default";
    protected static ResourceBundle myResource;
    
    private TurtleObserver obs;

    public TurtlePane (int width, int height) {
        super(width, height);
        myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

        gc = this.getGraphicsContext2D(); 
        gc.setFill(Color.valueOf(myResource.getString("backgroundColors")));
        gc.fillRect(0,0,width,height);
        
        
        obs = new TurtleObserver(gc);
        List<Observer> ob = new ArrayList<Observer>();
        ob.add(obs);
        
        
        myTurtle = new Turtle(ob);
        obs.addSubject(myTurtle);
        drawTurtle();
//        gc.strokeLine(1, 1, 20, 20);
//        
//        gc.setFill(Color.GREEN);
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.beginPath();
//        gc.moveTo(50, 50);
//        gc.bezierCurveTo(150, 20, 150, 150, 75, 150);
//        gc.closePath();
//        myTurtle.changeImage();
    }

    private void drawTurtle(){
    	gc.drawImage(myTurtle.getMyTurtle(), getWidth()/2, getHeight()/2);
    }
}
