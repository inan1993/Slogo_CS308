package GUI.viewbox;

public class VariableListBox extends AViewBox {

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
