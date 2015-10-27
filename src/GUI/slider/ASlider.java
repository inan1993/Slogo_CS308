package GUI.slider;

import javafx.scene.control.Slider;

public abstract class ASlider extends Slider{

	public ASlider(){
		super();
		this.setPrefWidth(120);		
		this.setShowTickLabels(true);
		this.setBlockIncrement(1);
	}
}
