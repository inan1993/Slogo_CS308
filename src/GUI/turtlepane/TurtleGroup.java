package GUI.turtlepane;

import java.util.List;
import datatransferobjects.TurtleTransferObject;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleGroup extends Group{

    private List<Double> myTurtleIDs;
    private Image myTurtleImage;
    
    public TurtleGroup (Image turtleImage, List<Double> IDs) {
        super();
        this.myTurtleIDs = IDs;
        this.myTurtleImage = turtleImage;
    }
    
    public void setImage(Image newImage){
        this.myTurtleImage = newImage;
    }
    
    public void clear(){
        for(double id: myTurtleIDs){
            this.getChildren().remove(id);
        }
    }
    
    public void updateTurtles(TurtleTransferObject turtleDTO){
        if(myTurtleIDs.contains(turtleDTO.getID())){
            System.out.println("match");
            this.getChildren().remove(myTurtleIDs.indexOf(turtleDTO.getID()));
            myTurtleIDs.remove(turtleDTO.getID());
        }
        myTurtleIDs.add(turtleDTO.getID());
        ImageView turtleImage = new ImageView(myTurtleImage);
        turtleImage.setX(200);//turtleDTO.getNextLoc()[0]);
        turtleImage.setY(250);//turtleDTO.getNextLoc()[1]);
        turtleImage.setVisible(true);//turtleDTO.isVisible());
        this.getChildren().add(turtleImage);
    }

}