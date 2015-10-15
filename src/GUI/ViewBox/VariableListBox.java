package GUI.ViewBox;

public class VariableListBox extends ViewBox {

    public VariableListBox (String text){
        super(text);
    }

    @Override
    void setSize () {
        textArea.setPrefSize(400, 200);
    }

    @Override
    void setStyle () {
        textArea.setStyle("-fx-border-color: black;");
    }

}
