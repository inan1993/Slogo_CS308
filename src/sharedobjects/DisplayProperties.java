/**
 * 
 */
package sharedobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import exceptions.NotImplementedException;
import exceptions.WontImplementException;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * @author loganrooper
 *
 */
public class DisplayProperties extends Observable {
	private static final String DEFAULT_GUI_RESOURCE = "GUI.view";
	protected static ResourceBundle myResource;
	Map<Integer, Color> colorPalette;
	Color bgColor;
	private int myPenColor;
	private double penThickness;
	private String lineType;
	private Boolean penDown;

	public DisplayProperties() {
		// Defaults
		myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
		myPenColor = 0; // Color.valueOf(myResource.getString("defaultPenColor"));
		penThickness = Integer.parseInt(myResource.getString("defaultLineThickness"));
		setLineType(myResource.getString("defaultLineType"));
		bgColor = Color.valueOf(myResource.getString("defaultBackgroundColor"));
		colorPalette = new HashMap<Integer, Color>();
		createDefaultPalette();
		setPenDown(true);
		this.setChanged();
	}

	public void setPenColor(int index) {
		myPenColor = index;
		penUpdate();
	}

	public double getPenColor() {
		return myPenColor;
	}

	public void setPenThickness(double t) {
		penThickness = t;
		penUpdate();
	}

	public double getPenThickness() {
		return penThickness;
	}

	public String getPenState() {
		return lineType;
	}

	public void setPenState(String state) {
		this.lineType = state;
		penUpdate();
	}

	public void setPenShape(int index) {
		throw new WontImplementException();
	}

	private void createDefaultPalette() {
		String[] defColors = myResource.getString("defaultPalette").split(",");
		for (int i = 0; i < defColors.length; i++) {
			colorPalette.put(i, Color.valueOf(defColors[i]));
		}
		paletteUpdate();
	}

	public void newPaletteColor(int index, double r, double g, double b) {
		Color color = new Color(r, g, b, .99);
		colorPalette.put(index, color);
		paletteUpdate();
	}

	public Color getPaletteColor(double index) {
		return colorPalette.get(index - 1);
	}

	public void setBgColor(int index) {
		bgColor = colorPalette.get(index - 1);
		bgChange();
	}

	public Color getBgColor() {
		return bgColor;
	}

	public double getShape() {
		throw new WontImplementException();
	}

	private void penUpdate() {
		this.setChanged();
		notifyObservers("pen");
	}

	private void bgChange() {
		this.setChanged();
		notifyObservers("bg");
	}

	private void paletteUpdate() {
		this.setChanged();
		notifyObservers("palette");
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public Boolean getPenDown() {
		return penDown;
	}

	public void setPenDown(Boolean penDown) {
		this.penDown = penDown;
	}

}
