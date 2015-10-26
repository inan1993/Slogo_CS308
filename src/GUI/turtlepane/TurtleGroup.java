package GUI.turtlepane;

import java.util.List;
import java.util.ResourceBundle;

import datatransferobjects.TurtleTransferObject;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleGroup extends Group{
	private static final String TURTLE_RESOURCE_PACKAGE = "GUI.turtlepane/default";
	protected static ResourceBundle myResource;
	private List<Double> myTurtleIDs;
	private Image myTurtleImage;
	int width,height;

	public TurtleGroup (Image turtleImage, List<Double> IDs) {
		super();
		this.myTurtleIDs = IDs;
		this.myTurtleImage = turtleImage;
		myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);
		width = Integer.valueOf(myResource.getString("width"));
		height = Integer.valueOf(myResource.getString("height"));
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
			this.getChildren().remove(myTurtleIDs.indexOf(turtleDTO.getID()));
			myTurtleIDs.remove(turtleDTO.getID());
		}
		drawTurtle(turtleDTO);
	}

	private void drawTurtle(TurtleTransferObject turtleDTO) {
		myTurtleIDs.add(turtleDTO.getID());
		ImageView turtleImage = new ImageView(myTurtleImage);
		turtleImage.setX(turtleDTO.getNextLoc()[0]+width/2-(myTurtleImage.getWidth()/2));
		turtleImage.setY(turtleDTO.getNextLoc()[1]+height/2-(myTurtleImage.getHeight()/2)); // need to change the hardcoded
		turtleImage.setVisible(true);//turtleDTO.isVisible());
		//turtleImage.setRotate(value);
		//turtleImage.setOnMouseClicked(//make the turtle active);
		this.getChildren().add(turtleImage);
	}
}