package GUI.slider;

import javafx.scene.control.Slider;

public class OpacitySlider extends Slider {
	public OpacitySlider() {
		super();
		this.setMin(0.1);
		this.setMax(1.0);
		this.setValue(1);
		this.setPrefWidth(100);		
		this.setShowTickLabels(true);
		this.setShowTickLabels(true);
		this.setMajorTickUnit(1);
		this.setBlockIncrement(1);
		
	}
}
