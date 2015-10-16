package GUI.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class AButton extends Button{

    public AButton (String text, EventHandler<ActionEvent> event) {
        super(text);
        this.setPrefWidth(155);
        this.setStyle("-fx-border-color: black;");
        this.setOnAction(event);
    }
    public AButton (String text) {
        super(text);
        this.setPrefWidth(155);
        this.setStyle("-fx-border-color: black;");
    }
}
