/**
 * 
 */
package sharedobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;

/**
 * @author loganrooper
 *
 */
public class DisplayProperties extends Observable {
	private static final String DEFAULT_GUI_RESOURCE = "GUI.view";
	protected static ResourceBundle myResource;

	Map<Integer, Color> colorPalette;
	Color bgColor;
    
	
	public DisplayProperties() {
		//Default display values
		myResource = ResourceBundle.getBundle(DEFAULT_GUI_RESOURCE);
		bgColor = Color.valueOf(myResource.getString("backgroundColors"));
		colorPalette = new HashMap<Integer, Color>();
		createDefaultPalette();
	}
	
	private void createDefaultPalette() {
		String[] defColors = myResource.getString("defaultPalette").split(",");
		for(int i=0; i<defColors.length; i++){
			colorPalette.put(i, Color.valueOf(defColors[i]));
		}
	}

	public void newPaletteColor(int index, double r, double g, double b){
		Color color = new Color(r,g,b,.99);
		colorPalette.put(index,color);
	}
	
	public Color getPaletteColor(int index){
		return colorPalette.get(index-1);
	}
	
	public void setBgColor(int index){
		bgColor = colorPalette.get(index-1);
	}
	
	public Color getBgColor(){
		return bgColor;
	}
}
