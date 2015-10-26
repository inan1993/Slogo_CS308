package observers;

import java.util.Observable;
import java.util.Observer;
import GUI.viewbox.TurtleStateBox;

public class TurtleStateBoxObserver implements Observer{

    private TurtleStateBox myTurtleStateBox;
    public TurtleStateBoxObserver (TurtleStateBox turtleStateBox) {
        this.myTurtleStateBox = turtleStateBox;
    }

    @Override
    public void update (Observable o, Object arg) {
//        TurtleTransferObject turtleDTO = (TurtleTransferObject) arg;
//        myTurtleStateBox.updateTurtleStateBox(turtleDTO);
    }

}
