package GUI.viewbox;

import GUI.textBox.CommandPromptDisplayBox;

public class FunctionListBox extends AViewBox {

    public FunctionListBox (CommandPromptDisplayBox display){
        super(display);
        this.setText("Function List");
    }

    @Override
    void setStyle () {
        listView.setStyle("-fx-border-color: black;");        
    }

    @Override
    void setSize () {
        listView.setPrefSize(400,200);        
    }

}
