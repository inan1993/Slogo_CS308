package GUI.dropdown;

public class FileDropdown extends ADropdownBox{

	public FileDropdown () {
		super("File");
        this.getItems().addAll(myResource.getString("fileList").split(","));

	}
}
