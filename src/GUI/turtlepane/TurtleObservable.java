package GUI.turtlepane;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.Image;

public class TurtleObservable extends Observable{
    private Image myTurtleImage;	
    private List<Observer> myObserver;
    private String ID;
    
    public TurtleObservable(List<Observer> observers){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = turtle;
        myObserver = observers;
    }

    public TurtleObservable(){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = turtle;
    }
    public Image getMyTurtle() {
        return myTurtleImage;
    }
    
    public String getID() {
        return ID;
    }

    public void addObserver(Observer observer){
        myObserver.add(observer);
    }

    public void changeImage(){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle2.png"));
        myTurtleImage = turtle;
        for(Observer observer : myObserver){
            observer.update(this, null);
        }
    }



}