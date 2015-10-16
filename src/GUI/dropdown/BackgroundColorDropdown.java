package GUI.dropdown;

public class BackgroundColorDropdown extends ADropdownBox {
    
    
    public BackgroundColorDropdown (String value) {
        super(value);
        this.getItems().addAll(myResource.getString("backgroundColors").split(","));
    }


}
