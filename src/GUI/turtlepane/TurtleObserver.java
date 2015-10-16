package GUI.turtlepane;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.canvas.GraphicsContext;

public class TurtleObserver implements Observer{

    private GraphicsContext myGc;
    private Turtle myTurtle;
    public TurtleObserver (GraphicsContext gc) {
        this.myGc = gc;
    }

    public void addSubject(Turtle turtle){
        this.myTurtle=turtle;
    }
    
    @Override
    public void update (Observable o, Object arg) {
        if(myTurtle == o){
            System.out.println("match");
            myGc.drawImage(myTurtle.getMyTurtle(), 30.2, 32.2);
        }
    }
}
