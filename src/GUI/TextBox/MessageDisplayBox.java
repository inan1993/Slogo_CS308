package GUI.TextBox;

public class MessageDisplayBox extends TextDisplayBox {

    public MessageDisplayBox () {
        super();
        this.setPromptText("Internal Message");
        this.setStyle("-fx-border-color: red;");
        this.setPrefSize(650, 20);
        this.setWrapText(true);
    }

}
