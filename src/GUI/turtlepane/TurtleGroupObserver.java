package GUI.turtlepane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sharedobjects.Turtle;

public class TurtleGroupObserver extends Group implements Observer{

    private static final String DEFAULT_GUI_RESOURCE = "GUI.view";

    private List<Integer> myTurtleIDs;
    private Image myTurtleImage;
    double width,height;

    public TurtleGroupObserver () {
        super();
        ResourceBundle myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
        this.myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle")));
        this.myTurtleIDs = new ArrayList<Integer>();
        width = Integer.parseInt(myResource.getString("canvasWidth"));
        height = Integer.parseInt(myResource.getString("canvasHeight"));
    }

    public void setImage(Image newImage){
        this.myTurtleImage = newImage;
    }

    public void clear(){
        //        for(double id: myTurtleIDs){
        //            this.getChildren().remove(id);
        //        }
        this.getChildren().removeAll();
    }

    private void drawTurtle(Turtle turtle) {
        myTurtleIDs.add(turtle.getID());
        ImageView turtleImage = new ImageView(myTurtleImage);
        turtleImage.setX(turtle.getPosition()[0]+width/2.0-(myTurtleImage.getWidth()/2.0));
        turtleImage.setY(turtle.getPosition()[1]+height/2.0-(myTurtleImage.getHeight()/2.0)); // need to change the hardcoded
        turtleImage.setVisible(turtle.isShowing());
        turtleImage.setRotate(90-turtle.getHeading());
        //turtleImage.setOnMouseClicked(//make the turtle active);
        this.getChildren().add(turtleImage);
    }

    @Override
    public void update (Observable o, Object arg) {
        Turtle turtleObservable = (Turtle) o;
        System.out.println(this.getClass().getName()+": gothim"); 
        Iterator<Integer> it = myTurtleIDs.iterator();
        while(it.hasNext()){
            if(it.next() == turtleObservable.getID()){
                this.getChildren().remove(myTurtleIDs.indexOf(turtleObservable.getID()));
                it.remove();
            }
        }
        drawTurtle(turtleObservable);
    }
}