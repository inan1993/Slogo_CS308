package GUI.slider;

public class LineSlider extends ASlider{

	public LineSlider() {
		super();
		this.setMin(1.0);
		this.setMax(5.0);
		//this.setValue(1);
		this.setMajorTickUnit(1);		
	}
}
