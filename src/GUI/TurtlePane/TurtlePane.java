package GUI.TurtlePane;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TurtlePane extends Canvas{

    public TurtlePane (int width, int height) {
        super(width, height);
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0,0,width,height);
    }

}
