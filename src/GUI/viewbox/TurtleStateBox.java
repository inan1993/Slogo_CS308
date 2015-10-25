package GUI.viewbox;

import GUI.textBox.CommandPromptDisplayBox;

public class TurtleStateBox extends AViewBox {

	public TurtleStateBox (CommandPromptDisplayBox display){
        super(display);
        this.setText("Turtle State List");
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
