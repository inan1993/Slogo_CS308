package observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import GUI.SlogoView;
import GUI.turtlepane.CanvasObserver;
import GUI.turtlepane.TurtleGroupObserver;

public class ObserverFactory {

    private List<Observer> myObservers;

    private TurtleGroupObserver guiTurtleGroup;
    private CanvasObserver guiCanvas;

    //    private SlogoView mySlogoView;

    public ObserverFactory () {
        this.myObservers = new ArrayList<Observer>();
        createObservers();
    }

    private void createObservers(){
        myObservers.add(guiTurtleGroup = new TurtleGroupObserver());
        myObservers.add(guiCanvas = new CanvasObserver());
    }

    public void createObserversWithGUIDependancies(SlogoView slogoView){
        myObservers.add(new ParsedCommandsObserver(slogoView.getFunctionDisplayBox(), slogoView.getVariableDisplayBox()));
        myObservers.add(new TurtleStateBoxObserver(slogoView.getTurtleStateBox()));
    }

    public List<Observer> getObservers(){
        return myObservers;
    }

    public TurtleGroupObserver getGuiTurtleGroup () {
        return guiTurtleGroup;
    }

    public CanvasObserver getGuiCanvas () {
        return guiCanvas;
    }
}
