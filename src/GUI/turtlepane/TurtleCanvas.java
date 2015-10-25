package GUI.turtlepane;

import java.util.ResourceBundle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
			System.out.println("x: "+startLoc[0]+width/2 + " y: " +startLoc[1]+height/2);
			System.out.println("x: "+endLoc[0]+width/2 +" y: " + endLoc[1]+height/2);
			//gc.strokeLine(width/2, height/2, 20+width/2, 40/width/2);
			gc.setLineWidth(3);

		}
	}

	
	public void setLineType(String line) {
		if (line.equalsIgnoreCase("solid")){
			gc.setLineWidth(1);
		}else if (line.equalsIgnoreCase("dashed")){
			gc.setLineDashOffset(5f);
			gc.setLineDashes(5f,5f);
		}else if(line.equalsIgnoreCase("dotted")){
			gc.setLineDashOffset(2f);
			gc.setLineDashes(1f,1f);
		}

	}

	public void setPenWidth(Double penWidth){
		gc.setLineWidth(penWidth);
	}
}
