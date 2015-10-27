package observers;

import java.util.Observable;
import java.util.Observer;
import GUI.viewbox.TurtleStateBox;
import sharedobjects.Turtle;
import sharedobjects.TurtleContainer;

public class TurtleStateBoxObserver implements Observer{

    private TurtleStateBox myTurtleStateBox;
    public TurtleStateBoxObserver (TurtleStateBox turtleStateBox) {
        this.myTurtleStateBox = turtleStateBox;
    }

    @Override
    public void update (Observable o, Object arg) {
    	TurtleContainer turtleContainer = (TurtleContainer) o;
		for(Turtle t: turtleContainer.getAllTurtles().values()){
			myTurtleStateBox.updateTurtleStateBox(t);			
		}
    }

}
