package GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;

import GUI.SlogoModel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class SlogoView {

	public static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private ResourceBundle myResources;
    private Scene scene;
    SlogoModel myModel;
    
    private Button enterButton;
    private Button clearButton;
    private Button helpButton;
    
    public SlogoView(SlogoModel model, String language, String classname) {
        // classname: passed to the 
    	
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    	BorderPane root = new BorderPane();
    	
    	enableButtons(classname);
    	
    	root.setRight(variableBox(classname)); // variable, function, history
    	root.setCenter(turtleScreen(classname)); // turtle movement screen
    	root.setTop(menuBars(classname)); // menu bars
    	root.setBottom(commandBox(classname)); // command entry, enter, clear, message box

    
    
    }
    
    public Scene getScene(){
    	return scene;
    }
    
    
    private void enableButtons (String classname) {
        clearButton.setDisable(false);//((!myModel).clear());
        enterButton.setDisable(false);
        helpButton.setDisable(true);
        
    }
  
    private Node variableBox(String classname){
		return null;
    	
    }
    
    private Node menuBars(String classname){
    	return null;
    }
    
    private Node commandBox(String classname){
    	TextArea textArea = new TextArea();
    	textArea.setOnMouseClicked(null);
    	
    	return null;
    }
    
    private Node turtleScreen(String classname){
		return null;
    	
    }
    
}
