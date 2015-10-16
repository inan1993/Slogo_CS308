package GUI.Dropdown;

public class BackgroundColorDropdown extends ADropdownBox {
    
    
    public BackgroundColorDropdown (String value) {
        super(value);
        this.getItems().addAll(myResource.getString("backgroundColors").split(","));
    }


}
