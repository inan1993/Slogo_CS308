package GUI.turtlepane;

import java.awt.BasicStroke;
import java.awt.Stroke;
import java.util.ResourceBundle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TurtleCanvas extends Canvas{

	private GraphicsContext gc;
	private static final String TURTLE_RESOURCE_PACKAGE = "GUI.turtlepane/default";
	protected static ResourceBundle myResource;
	int width, height;

	private Color penColor;

	public TurtleCanvas (int width, int height) {
		super(width, height);
		this.width = width;
		this.height = height;
		myResource = ResourceBundle.getBundle(TURTLE_RESOURCE_PACKAGE);

		gc = this.getGraphicsContext2D(); 
		gc.setFill(Color.TRANSPARENT);
		gc.fillRect(0,0,width,height);

		this.penColor = Color.valueOf(myResource.getString("penColors"));
		gc.setStroke(penColor);

	}

	public void clear(){
		gc.clearRect(0,0,width,height);
	}

	public void setPenColor(String newPenColor){
		this.penColor = Color.valueOf(newPenColor);
		gc.setStroke(penColor);

	}

	public void drawLine(int[]startLoc, int[] endLoc, boolean draw){
		if(draw){
			gc.setStroke(penColor);
			gc.strokeLine(startLoc[0]+width/2, startLoc[1]+height/2, endLoc[0]+width/2, endLoc[1]+height/2); 

		}
	}

	public void setLineType(String line) {
		if (line.equalsIgnoreCase("solid"))
			gc.setLineWidth(3);
		else if (line.equalsIgnoreCase("dashed")){
			gc.setLineDashOffset(2f);
			gc.setLineDashes(4f,4f);
		}else if(line.equalsIgnoreCase("dotted")){
			gc.setLineDashes(1f,1f);
		}

	}
}
