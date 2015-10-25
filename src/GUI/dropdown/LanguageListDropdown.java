package GUI.dropdown;

public class LanguageListDropdown extends ADropdownBox {

    public LanguageListDropdown () {
        super("Languages");
        this.getItems().addAll(myResource.getString("languageList").split(","));
    }

}
