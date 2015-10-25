package observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import GUI.SlogoView;

public class ObserverFactory {

    private SlogoView mySlogoView;
    private List<Observer> myObservers;
    
    public ObserverFactory (SlogoView slogoView) {
        this.mySlogoView = slogoView;
        this.myObservers = new ArrayList<Observer>();
        createObservers();
    }

    private void createObservers(){
        myObservers.add(new TurtlePaneObserver(mySlogoView.getTurtlePaneGroup(), mySlogoView.getTurtlePaneCanvas()));
        myObservers.add(new ParsedCommandsObserver(mySlogoView.getFunctionDisplayBox(), mySlogoView.getVariableDisplayBox()));
        myObservers.add(new TurtleStateBoxObserver(mySlogoView.getTurtleStateBox()));
    }
    
    public List<Observer> getObservers(){
        return myObservers;
    }
}
