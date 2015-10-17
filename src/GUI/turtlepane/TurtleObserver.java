package GUI.turtlepane;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.canvas.GraphicsContext;

public class TurtleObserver implements Observer{

    private GraphicsContext myGc;
    private List<String> myTurtleIDs = new ArrayList<String>();
    public TurtleObserver (GraphicsContext gc) {
        this.myGc = gc;
    }

    public void addSubject(Turtle turtle){
        this.myTurtleIDs.add(turtle.getID());
    }
    
    @Override
    public void update (Observable o, Object arg) {
        if(myTurtleIDs.contains((String)arg)){
            System.out.println("match");
            Turtle turtle = (Turtle) o;
           // myGc.drawImage(myTurtle.getMyTurtle(), 30.2, 32.2);
        }
    }
}
