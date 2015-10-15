package GUI.Button;

import javafx.scene.control.Button;

public abstract class Buttons extends Button{

    public Buttons (String text) {
        super(text);
        this.setPrefWidth(155);
        this.setStyle("-fx-border-color: black;");
    }

}
