
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import GUI.SlogoView;
import backend.parser.Parser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import observers.ObserverFactory;
import sharedobjects.HandleObservers;
import sharedobjects.ManipulateController;
import sharedobjects.Workspace;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    private static SlogoView frontEnd;
    Scene scene;

    public  void start (Stage stage) throws Exception {
        stage.setTitle(TITLE);
        stage.setScene(frontEnd.getScene()); 
        stage.setResizable(false);
        stage.sizeToScene(); 
        stage.show();
    }

    public static void main (String[] args) {

        /*4*/ frontEnd = new SlogoView(); //TODO: frontEnd must create an observers list

        try{
        /*1*/Workspace currWorkspace = new Workspace(); //TODO: workspace must create an observables list
        /*2*/ManipulateController manipulateController = new ManipulateController(currWorkspace);

        /*3*/Parser parser = new Parser(manipulateController);
        ObserverFactory observerFactory = new ObserverFactory(frontEnd);
        
        List<Observable> observables = new ArrayList<Observable>();
        observables.addAll(currWorkspace.getObservables()); 
        observables.add(frontEnd.getObservable());
        
        List<Observer> observers = new ArrayList<Observer>();
        observers.addAll(observerFactory.getObservers()); 
        observers.add(parser);
        /*6*/ HandleObservers.handleObservers(observables, observers);
        
        currWorkspace.startWorkspace();
        }
        catch(Exception e){
            e.printStackTrace();
            frontEnd.showError(e);
        }
        
        
        

//        manipulateController.setHeading(0);
//        manipulateController.foward(50);
        launch(args);
    }
}
