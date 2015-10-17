
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import GUI.SlogoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sharedobjects.HandleObservers;
import sharedobjects.ManipulateController;
import sharedobjects.Workspace;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    //private Map<Observable, Observer> observingMap;
    private static SlogoView frontEnd;
    Scene scene;
	
	public  void start (Stage stage) throws Exception {
        stage.setTitle(TITLE);
        stage.setScene(frontEnd.getScene()); 
        stage.setResizable(false);
        stage.sizeToScene(); 
        stage.show();
<<<<<<< HEAD
    }
=======
	}
>>>>>>> abhishek
	
    public static void main (String[] args) {
    	/*1*/Workspace currWorkspace = new Workspace(); //TODO: workspace must create an observables list
    	/*2*/ManipulateController manipulateController = new ManipulateController(currWorkspace);
    	
    	/*3*/ //Executor executor = new Executor(manipulateController);
    	/*4*/ //Parser parser = new Parser(executor);
    	
    	/*5*/ frontEnd = new SlogoView("SEND PARSER HERE"); //TODO: frontEnd must create an observers list
        
    	HandleObservers handleObservers = new HandleObservers();   
    	/*6*/ //HandleObservers.handleObservers(currWorspace.getObservables(), frontEnd.getObservers());
        launch(args);
        
    }
<<<<<<< HEAD
=======

>>>>>>> abhishek
}
