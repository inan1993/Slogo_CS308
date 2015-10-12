package GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class SlogoModel {

    private List<String> commandHistory;
    private Color turtlePaneBackgroundColor;

    
    public SlogoModel(){
        commandHistory = new ArrayList<String>();
        turtlePaneBackgroundColor = Color.LIGHTGREEN;
    }
    
    public void addHistory(String command){
        System.out.println("new command:"+command);
        commandHistory.add(command);
    }
    
    public Color getBackgroundColor(){
        return turtlePaneBackgroundColor;
    }
    
    public void setBackgroundColor(Color color){
        turtlePaneBackgroundColor = color;
    }
}
