package GUI.slider;

import javafx.scene.control.Slider;

public class LineSlider extends Slider{

	public LineSlider() {
		super();
		this.setMin(1.0);
		this.setMax(5.0);
		this.setValue(1);
		this.setPrefWidth(100);		
		this.setShowTickLabels(true);
		this.setShowTickLabels(true);
		this.setMajorTickUnit(1);
		this.setBlockIncrement(1);
		
	}
}
