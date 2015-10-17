package GUI.turtlepane;

import java.util.ResourceBundle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TurtleCanvas extends Canvas{

    private GraphicsContext gc;
    private static final String TURTLE_RESOURCE_PACKAGE = "GUI.turtlepane/default";
    protected static ResourceBundle myResource;

    private Color penColor;
    private Color bgColor;

    public TurtleCanvas (int width, int height) {
        super(width, height);
        myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

        this.bgColor = Color.valueOf(myResource.getString("backgroundColors"));
        gc = this.getGraphicsContext2D(); 
        gc.setFill(bgColor);
        gc.fillRect(0,0,width,height);

        this.penColor = Color.valueOf(myResource.getString("penColors"));
        gc.setStroke(penColor);

    }

    public void clear(){
        this.clear();
        gc.setFill(bgColor);
        gc.fillRect(0,0,800,580);
    }

    public void setBackgroundColor(String backgroundColor){
        this.bgColor = Color.valueOf(backgroundColor);
        gc.setFill(bgColor);
        System.out.println(backgroundColor);
        gc.fillRect(0,0,800,580);
    }

    public void setPenColor(String penColor){
        this.penColor = Color.valueOf(penColor);
    }

    public void drawLine(int[]startLoc, int[] endLoc, boolean draw){
        if(draw){
            gc.setStroke(penColor);
            gc.strokeLine(startLoc[0], startLoc[1], endLoc[0], endLoc[1]);            
        }
    }



    //        obs = new TurtleObserver(gc);
    //        List<Observer> ob = new ArrayList<Observer>();
    //        ob.add(obs);
    //        
    //        
    //        myTurtle = new Turtle(ob);
    //        obs.addSubject(myTurtle);
    //        myTurtle.drawTurtle();
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
