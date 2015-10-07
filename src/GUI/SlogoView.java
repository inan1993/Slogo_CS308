package src.GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    public SlogoView(SlogoModel model, String language) {
        
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

    	BorderPane root = new BorderPane();
    	
    	enableButtons();
    	
    	root.setRight(variableBox()); // variable, function, history
    	root.setCenter(turtleScreen()); // turtle movement screen
    	root.setTop(menuBars()); // menu bars
    	root.setBottom(commandBox()); // command entry, enter, clear, message box

    
    
    }
    
    public Scene getScene(){
    	return scene;
    }
    
    
    private void enableButtons () {
        clearButton.setDisable(false);//((!myModel).clear());
        enterButton.setDisable(false);
        helpButton.setDisable(true);
        
    }
  
    private Node variableBox(){
		return null;
    	
    }
    
    private Node menuBars(){
    	return null;
    }
    
    private Node commandBox(){
    	
    	return null;
    }
    
    private Node turtleScreen(){
		return null;
    	
    }
    
}
