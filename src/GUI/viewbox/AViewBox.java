package GUI.viewbox;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

public abstract class AViewBox extends TitledPane{

	ObservableList<String> data = FXCollections.observableArrayList();

	ListView<String> listView = new ListView<String>(data);

	public AViewBox (){//String text) {
		//this.setText(text);
		//textArea = new TextArea();
		setSize();
		setStyle();
		this.setContent(listView);
	}

	public void setMessage(String message){
		data.add(message);
		listView.setItems(data);
		listView.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends String> ov, String old_val, 
						String new_val) -> {
							System.out.println(new_val);

						});
	}

	abstract void setStyle();        
	abstract void setSize();

}
