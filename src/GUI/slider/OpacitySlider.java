package GUI.slider;

public class OpacitySlider extends ASlider {
	public OpacitySlider() {
		super();
		this.setMin(0.1);
		this.setMax(1.0);
		this.setValue(1);
		this.setMajorTickUnit(0.2);		
	}
}
