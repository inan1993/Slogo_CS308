package GUI.textBox;

import javafx.scene.control.TextArea;

public class MessageDisplayBox extends TextArea {

    public MessageDisplayBox () {
        super();
        this.setPromptText("Internal Message");
        this.setPrefSize(650, 20);
        this.setStyle("-fx-text-fill: blue; -fx-font-size: 14; -fx-background-color: red;");
        this.setWrapText(true);
        
    }

    public void setMessage(String message){
        this.clear();
        this.setText(message);
    }
}
