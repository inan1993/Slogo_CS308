package GUI.turtlepane;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.Image;

public class Turtle extends Observable{
    private Image myTurtleImage;	
    private List<Observer> myObserver;
    public Turtle(List<Observer> observers){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = turtle;
        myObserver = observers;
    }

    public Turtle(){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = turtle;
    }
    public Image getMyTurtle() {
        return myTurtleImage;
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