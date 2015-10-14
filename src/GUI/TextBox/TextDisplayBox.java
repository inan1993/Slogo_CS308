package GUI.TextBox;

import javafx.scene.control.TextArea;

public abstract class TextDisplayBox extends TextArea{

    public TextDisplayBox () {
        // TODO Auto-generated constructor stub
    }
    
    public void setMessage(String message){
        this.clear();
        this.setText(message);
    }
}
