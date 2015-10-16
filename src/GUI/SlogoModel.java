package GUI;

import java.util.ArrayList;
import java.util.List;

import GUI.TurtlePane.Turtle;
import javafx.scene.paint.Color;

public class SlogoModel {

    private List<String> commandHistory;
    private Color turtlePaneBackgroundColor;
    private Turtle myTurtle;

    
    public SlogoModel(){
        commandHistory = new ArrayList<String>();
        setBackgroundColor("BLACK");
        //turtlePaneBackgroundColor = Color.LIGHTGREEN;
        myTurtle = new Turtle();
    }
    
    public void addHistory(String command){
        System.out.println("new command:"+command);
        commandHistory.add(command);
       
    }
    
    public Color getBackgroundColor(){
        return turtlePaneBackgroundColor;
    }
    
    public void setBackgroundColor(String color){    
        turtlePaneBackgroundColor = Color.WHITE;
    }
    
    public Turtle getTurtle(){
    	return myTurtle;
    }
}
