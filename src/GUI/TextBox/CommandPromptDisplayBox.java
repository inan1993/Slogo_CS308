package GUI.TextBox;

public class CommandPromptDisplayBox extends TextDisplayBox {

    public CommandPromptDisplayBox () {
        super();
        this.setPromptText("Enter command here");
        this.setStyle("-fx-border-color: black;");
        this.setPrefSize(650, 70);
    }
    
}
