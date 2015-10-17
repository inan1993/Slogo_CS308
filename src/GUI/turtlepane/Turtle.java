package GUI.turtlepane;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends Observable{
    private ImageView myTurtleImage;    
    private List<Observer> myObserver;
    private String ID;

    public Turtle(List<Observer> observers){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = new ImageView(turtle);
        myObserver = observers;
    }

    public Turtle(){
        Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
        myTurtleImage = new ImageView(turtle);
    }

    public ImageView getMyTurtle() {
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
        myTurtleImage = new ImageView(turtle);
        for(Observer observer : myObserver){
            observer.update(this, null);
        }
    }

    public void drawTurtle(){
        myTurtleImage.setVisible(true);
        //              myTurtleImage.setX(200);
        //              myTurtleImage.setY(100);
        System.out.println("turtle");
    }

    public void drawTurtle2(){
        myTurtleImage.setVisible(true);
        myTurtleImage.setX(200);
        myTurtleImage.setY(100);
        System.out.println("turtle");
    }
}
