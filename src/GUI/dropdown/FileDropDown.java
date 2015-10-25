package GUI.dropdown;

import GUI.textBox.MessageDisplayBox;

public class FileDropdown extends ADropdownBox{
	private MessageDisplayBox messageBox;

	public FileDropdown () {
		super("File");
		this.setOnAction((event1->{
			String text = this.getValue();
			if(text.equalsIgnoreCase("New Workspace")){
				//centerBox();
			}else if(text.equalsIgnoreCase("Save Workspace")){
				//centerBox();
			}
			messageBox.setMessage(text + " executed");
		}));
		this.getItems().addAll(myResource.getString("fileList").split(","));
	}
}
