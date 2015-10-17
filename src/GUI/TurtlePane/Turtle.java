package GUI.TurtlePane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Turtle extends ImageView {
	private Image myTurtleImage;	

	public Turtle(){
		Image turtle = new Image(getClass().getClassLoader().getResourceAsStream("images/turtle1.png"));
		myTurtleImage = turtle;
	}

	public Image getMyTurtle() {
		return myTurtleImage;
	}

}
