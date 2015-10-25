package GUI.dropdown;

public class PenColorDropdown extends ADropdownBox {

    public PenColorDropdown () {
        super("Pen Color");
        this.getItems().addAll(myResource.getString("penColors").split(","));
    }

}
