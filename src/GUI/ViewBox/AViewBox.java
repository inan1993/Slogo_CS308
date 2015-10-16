package GUI.ViewBox;

import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

public abstract class AViewBox extends TitledPane{
    
    TextArea textArea;
    
    public AViewBox (String text) {
        this.setText(text);
        textArea = new TextArea();
        setSize();
        setStyle();
        this.setContent(textArea);
    }
    

    public void addText(String text){
        textArea.appendText(text+"\n");
    }
    
    abstract void setStyle();        
    abstract void setSize();

}
