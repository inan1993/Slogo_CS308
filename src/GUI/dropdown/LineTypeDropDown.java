package GUI.dropdown;

public class LineTypeDropDown extends ADropdownBox{

	public LineTypeDropDown (String value) {
        super(value);
        this.getItems().addAll(myResource.getString("lineProperties").split(","));
    }
}
