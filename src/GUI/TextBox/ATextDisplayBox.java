package GUI.TextBox;

import javafx.scene.control.TextArea;

public abstract class ATextDisplayBox extends TextArea{

    public ATextDisplayBox () {
        // TODO Auto-generated constructor stub
    }
    
    public void setMessage(String message){
        this.clear();
        this.setText(message);
    }
}
