package GUI.Dropdown;

public class LanguageListDropdown extends DropdownBox {

    public LanguageListDropdown (String value) {
        super(value);
        this.getItems().addAll(myResource.getString("languageList").split(","));
    }

}
