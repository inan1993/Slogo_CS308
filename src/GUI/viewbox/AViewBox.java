package GUI.viewbox;

import GUI.textBox.CommandPromptDisplayBox;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

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
        data.add(message);
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                                                                        (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                                                                            System.out.println(new_val);
                                                                            myDisplay.setText(new_val);
                                                                        });
    }

    abstract void setStyle();        
    abstract void setSize();

}
