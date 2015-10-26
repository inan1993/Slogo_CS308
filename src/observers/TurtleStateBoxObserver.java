package observers;

import java.util.Observable;
import java.util.Observer;
import GUI.viewbox.TurtleStateBox;
import sharedobjects.Turtle;

public class TurtleStateBoxObserver implements Observer{

    private TurtleStateBox myTurtleStateBox;
    public TurtleStateBoxObserver (TurtleStateBox turtleStateBox) {
        this.myTurtleStateBox = turtleStateBox;
    }

    @Override
    public void update (Observable o, Object arg) {
        Turtle turtle= (Turtle) o;
        myTurtleStateBox.updateTurtleStateBox(turtle);
    }

}
