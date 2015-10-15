package GUI.TurtlePane;

import GUI.SlogoModel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class TurtlePane extends Canvas{
    
    private SlogoModel mySlogoModel;
    private Turtle myTurtle;
    private GraphicsContext gc;
    public TurtlePane (int width, int height, SlogoModel slogoModel) {
        super(width, height);
        gc = this.getGraphicsContext2D();
        this.mySlogoModel = slogoModel;
        gc.setFill(mySlogoModel.getBackgroundColor());
        gc.fillRect(0,0,width,height);
        myTurtle = new Turtle();
        drawTurtle();
    }

    private void drawTurtle(){
    	gc.drawImage(myTurtle.getMyTurtle(), getWidth()/2, getHeight()/2);
    }
}
