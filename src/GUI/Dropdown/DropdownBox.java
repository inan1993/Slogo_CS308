package GUI.Dropdown;

import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;

public abstract class DropdownBox extends ComboBox<String>{

    private static final String DROPDOWN_RESOURCE_PACKAGE = "GUI.Dropdown/dropdown";

    protected static ResourceBundle myResource;
    public DropdownBox (String value) {
        super();
        myResource = ResourceBundle.getBundle(DROPDOWN_RESOURCE_PACKAGE);
        this.setValue(value);
        this.setEditable(false);       
        this.promptTextProperty();
    }

}
