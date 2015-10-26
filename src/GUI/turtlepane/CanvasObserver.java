package GUI.turtlepane;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import responses.Response;
import sharedobjects.Turtle;

public class CanvasObserver extends Canvas implements Observer {

	private GraphicsContext myGC;
	private static final String DEFAULT_GUI_RESOURCE = "GUI.view";
	protected static ResourceBundle myResource;
	int myWidth, myHeight;

	private Color myPenColor;

	public CanvasObserver() {
		super();
		myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
		myWidth = Integer.parseInt(myResource.getString("canvasWidth"));
		myHeight = Integer.parseInt(myResource.getString("canvasHeight"));
		this.setWidth(myWidth);
		this.setHeight(myHeight);

		myGC = this.getGraphicsContext2D();
		myGC.setFill(Color.TRANSPARENT);
		myGC.fillRect(0, 0, myWidth, myHeight);
		setDefaultPenAndStroke();
	}

	private void setDefaultPenAndStroke() {
		setPenColor(myResource.getString("defaultPenColor"));
		setLineType(myResource.getString("defaultLineType"));
		setPenWidth(Double.parseDouble(myResource.getString("defaultLineThickness")));
		myGC.setStroke(myPenColor);
	}

	public void clear() {
		myGC.clearRect(0, 0, myWidth, myHeight);
	}

	public void setPenColor(String newPenColor) {
		myPenColor = Color.valueOf(newPenColor);
		myGC.setStroke(myPenColor);
	}

	public void drawLine(double[] startLoc, double[] endLoc, boolean draw) {
		if (draw) {
			// myGC.setStroke(myPenColor);
			myGC.strokeLine(startLoc[0] + myWidth / 2.0, startLoc[1] + myHeight / 2.0, endLoc[0] + myWidth / 2.0,
					endLoc[1] + myHeight / 2.0);
		}
	}

	public void penUpDown() {
		System.out.println("check");
		myGC.clearRect(0, 0, myWidth, myHeight);
	}

	public void setLineType(String line) {
		if (line.equalsIgnoreCase("solid")) {
			myGC.setLineWidth(1);
		} else if (line.equalsIgnoreCase("dashed")) {
			myGC.setLineDashOffset(5f);
			myGC.setLineDashes(5f, 5f);
		} else if (line.equalsIgnoreCase("dotted")) {
			myGC.setLineDashOffset(4f);
			myGC.setLineDashes(2f, 2f, 2f, 2f);
		}
	}

	public void setPenWidth(Double penWidth) {
		myGC.setLineWidth(penWidth);
	}

	@Override
	public void update(Observable o, Object arg) {
//		if (((String) arg).equals("turtle")) {
			Turtle t = (Turtle) o;
			drawLine(t.getOldPosition(), t.getPosition(), t.isPenDown());
//		}
	}
}