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
import sharedobjects.TurtleContainer;

public class TurtleGroupObserver extends Group implements Observer{

    private static final String DEFAULT_GUI_RESOURCE = "GUI.view";

    private List<Integer> myTurtleIDs;
    private Image myTurtleImage;
    private double width,height;
    private double inactiveOpacity;
    private ResourceBundle myResource;

    public TurtleGroupObserver () {
        super();
        this.myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
        this.myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle")));
        this.myTurtleIDs = new ArrayList<Integer>();
        width = Integer.parseInt(myResource.getString("canvasWidth"));
        height = Integer.parseInt(myResource.getString("canvasHeight"));
        inactiveOpacity = Double.parseDouble(myResource.getString("inactiveTurtleOpacity"));
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

    public void changeOpacity(double value){
        this.setOpacity(value);

    }

    private void drawTurtle(Turtle turtle, List<Turtle> activeTurtles) {
        myTurtleIDs.add(turtle.getID());
        ImageView turtleImage = new ImageView(myTurtleImage);
        turtleImage.setX(turtle.getPosition()[0]+width/2.0-(myTurtleImage.getWidth()/2.0));
        turtleImage.setY(turtle.getPosition()[1]+height/2.0-(myTurtleImage.getHeight()/2.0));
        turtleImage.setVisible(turtle.isShowing());
        turtleImage.setRotate(90-turtle.getHeading());
        if(!activeTurtles.contains(turtle)){
            turtleImage.setOpacity(inactiveOpacity);
        }
        this.getChildren().add(turtleImage);
    }

    @Override
    public void update (Observable o, Object arg) {
        
        if(((String)arg).equals("dancingDuvall")){
            int c=0;
            for(int id: myTurtleIDs){
                this.getChildren().remove(c);
                c++;
            }
            ImageView duvall = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle"))));
            this.getChildren().add(duvall);
        }

        TurtleContainer turtleContainer = (TurtleContainer) o;
        for(Turtle t: turtleContainer.getAllTurtles().values()){
            Iterator<Integer> it = myTurtleIDs.iterator();
            while(it.hasNext()){
                if(it.next() == t.getID()){
                    this.getChildren().remove(myTurtleIDs.indexOf(t.getID()));
                    it.remove();
                }
            }
            drawTurtle(t, turtleContainer.getActiveTurtles());
        }
    }
}