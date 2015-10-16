package GUI.textBox;

import javafx.scene.control.TextArea;

public class MessageDisplayBox extends TextArea {

    public MessageDisplayBox () {
        super();
        this.setPromptText("Internal Message");
        this.setStyle("-fx-border-color: red;");
        this.setPrefSize(650, 20);
        this.setWrapText(true);
    }

    public void setMessage(String message){
        this.clear();
        this.setText(message);
    }
}
