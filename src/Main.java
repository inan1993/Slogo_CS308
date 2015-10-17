
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
import sharedobjects.ManipulateController;
import sharedobjects.Workspace;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    //private Map<Observable, Observer> observingMap;
    private static SlogoView frontEnd;
   
    //map of Observable (String name) to their Observers (List<String name>)
    private static final Map<String, List<String>> observableMap = new HashMap<String,List<String>>() {{
        put("Turtle", new LinkedList<String>(Arrays.asList("Observer1","Observer2")));
    }};
    
    Scene scene;
	
	public  void start (Stage stage) throws Exception {
        stage.setTitle(TITLE);
        stage.setScene(frontEnd.getScene()); 
        stage.setResizable(false);
        stage.sizeToScene(); 
        stage.show();
    }
	
    public static void main (String[] args) {
        Workspace currWorkspace = new Workspace();
        	//workspace must create an observables list
        frontEnd = new SlogoView("English");
        	//frontend must create an observers list
        
        //handleObservers(currWorspace.getObservables(), frontEnd.getObservers());
        
        ManipulateController manipulateController = new ManipulateController(currWorkspace);
        //Executor executor = new Executor(manipulateController);
        //Parser parser = new Parser(executor);
        launch(args);
        
    }
   

    //need to have the observers and obvervables linked by the workspace & frontend
	private void handleObservers(List<Observable> observablesOList, List<Observer> observersOList){
    	for(Observable observableO: observablesOList){
    		String observableName = observableO.getClass().getName();
    		List<String> observersSList = observableMap.get(observableName);
    		if(observersSList != null){
    			for(Observer observerO: observersOList){
    				String observerName = observerO.getClass().getName();	
    				if(observersSList.contains(observerName)){
    					linkObserverableObserver(observableO, observerO);
    				}
    			}
    		}
    	}
    }

	//TODO: Add observer link to observable 
	private void linkObserverableObserver(Observable observableO, Observer observerO) {
		//Perform Observer/Observable Linking
		observableO.addObserver(observerO);
		
	}
}
