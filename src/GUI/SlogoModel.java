package GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class SlogoModel {

    private List<String> commandHistory;
    private Color turtlePaneBackgroundColor;
    private Color penColor;
    private String language;

    
    public SlogoModel(){
        commandHistory = new ArrayList<String>();
        turtlePaneBackgroundColor = Color.LIGHTGREEN;
        penColor = Color.BLACK;
        language = "English";
    }
    
    public void addHistory(String command){
        commandHistory.add(command);
    }
    
    public Color getBackgroundColor(){
        return turtlePaneBackgroundColor;
    }
    
    public void setBackgroundColor(String bgColor){
        this.turtlePaneBackgroundColor = Color.valueOf(bgColor);
    }

    public Color getPenColor () {
        return penColor;
    }

    public void setPenColor (String penColor) {
        this.penColor = Color.valueOf(penColor);
    }

    public String getLanguage () {
        return language;
    }

    public void setLanguage (String language) {
        this.language = language;
    }
    
}
