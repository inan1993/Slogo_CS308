package GUI.viewbox;

import GUI.textBox.CommandPromptDisplayBox;

public class VariableListBox extends AViewBox {

    public VariableListBox (CommandPromptDisplayBox display){
        super(display);
        this.setText("Variables List");

    }

    @Override
    void setSize () {
        listView.setPrefSize(400, 200);
    }

    @Override
    void setStyle () {
        listView.setStyle("-fx-border-color: black;");
    }

}
