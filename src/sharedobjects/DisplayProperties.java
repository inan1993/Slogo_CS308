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
	private String penState;

	public DisplayProperties() {
		//Defaults
		myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
		myPenColor = 0; //Color.valueOf(myResource.getString("defaultPenColor"));
		penThickness = Integer.parseInt(myResource.getString("defaultLineThickness"));
		penState = myResource.getString("defaultLineType");
		bgColor = Color.valueOf(myResource.getString("defaultBackgroundColor"));
		colorPalette = new HashMap<Integer, Color>();
		createDefaultPalette();
		this.setChanged();
	}

	public void setPenColor(int index) {
		myPenColor = index;
		this.setChanged();
	}

	public double getPenColor() {
		return myPenColor;
	}
	
	public void setPenThickness(double t) {
		penThickness = t;
		this.setChanged();
	}

	public double getPenThickness() {
		return penThickness;
	}

	public String getPenState() {
		return penState;
	}

	public void setPenState(String state) {
		this.penState = state;
		this.setChanged();
	}

	public void setPenShape(int index) {
		throw new WontImplementException();
	}

	private void createDefaultPalette() {
		String[] defColors = myResource.getString("defaultPalette").split(",");
		for (int i = 0; i < defColors.length; i++) {
			colorPalette.put(i, Color.valueOf(defColors[i]));
		}
	}

	public void newPaletteColor(int index, double r, double g, double b) {
		Color color = new Color(r, g, b, .99);
		colorPalette.put(index, color);
		this.setChanged();
	}

	public Color getPaletteColor(int index) {
		return colorPalette.get(index - 1);
	}

	public void setBgColor(int index) {
		bgColor = colorPalette.get(index - 1);
		this.setChanged();
	}

	public Color getBgColor() {
		return bgColor;
	}

	public double getShape() {
		throw new WontImplementException();
	}
}
