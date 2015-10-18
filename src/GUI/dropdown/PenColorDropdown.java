package GUI.dropdown;

public class PenColorDropdown extends ADropdownBox {

    public PenColorDropdown (String value) {
        super(value);
        this.getItems().addAll(myResource.getString("penColors").split(","));
    }

}
