package SharedObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends ImageView {
	private Image myTurtleImage;	

	public Turtle(){
		Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("turtle1.png"));
		myTurtleImage = turtle;
	}

	public Image getMyTurtle() {
		return myTurtleImage;
	}

}
