package GUI.viewbox;

import GUI.textBox.CommandPromptDisplayBox;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.TextFieldListCell;

public abstract class AViewBox extends TitledPane{

	protected ObservableList<String> data;
	protected ListView<String> listView;
	private CommandPromptDisplayBox myDisplay;


	public AViewBox (CommandPromptDisplayBox display){
		this.data = FXCollections.observableArrayList();
		this.listView = new ListView<String>(data);
		setSize();
		setStyle();
		this.myDisplay = display;
		this.setContent(listView);
	}

	public void setMessage(String message){
		listView.setEditable(true);
		data.add(0,message);
		listView.setItems(data);
		listView.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends String> ov, String old_val, String new_val) -> {
					myDisplay.setText(new_val);
				});
		
		listView.setCellFactory(TextFieldListCell.forListView());		
		listView.setOnEditCommit(new EventHandler<ListView.EditEvent<String>>() {
			@Override
			public void handle(ListView.EditEvent<String> t) {
				listView.getItems().set(t.getIndex(), t.getNewValue());
			}

		});
	}

	abstract void setStyle();        
	abstract void setSize();

}
