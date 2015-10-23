package GUI.dropdown;

public class FileDropDown extends ADropdownBox{

	public FileDropDown (String value) {
		super(value);
		this.getItems().addAll(myResource.getString("fileList").split(","));
	}
}
