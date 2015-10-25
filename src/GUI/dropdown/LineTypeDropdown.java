package GUI.dropdown;

public class LineTypeDropdown extends ADropdownBox{

	public LineTypeDropdown () {
        super("Line Type");
        this.getItems().addAll(myResource.getString("lineProperties").split(","));
    }
}
