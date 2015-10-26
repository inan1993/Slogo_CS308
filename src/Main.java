
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
    private static SlogoView slogoViewFrontEnd;
    Scene scene;

    public  void start (Stage stage) throws Exception {
        stage.setTitle(TITLE);
        stage.setScene(slogoViewFrontEnd.getScene()); 
        stage.setResizable(false);
        stage.sizeToScene(); 
        stage.show();
    }

    public static void main (String[] args) {

        ObserverFactory observerFactory = new ObserverFactory();

        /*4*/ slogoViewFrontEnd = new SlogoView(observerFactory.getGuiCanvas(), observerFactory.getGuiTurtleGroup()); //TODO: frontEnd must create an observers list
        observerFactory.createObserversWithGUIDependancies(slogoViewFrontEnd);
        
        try{
          //TODO: workspace must create an observable list
        /*1*/Workspace currWorkspace = new Workspace(); 
        /*2*/ManipulateController manipulateController = new ManipulateController(currWorkspace);

        /*3*/Parser parser = new Parser(manipulateController);
        
        List<Observable> observables = new ArrayList<Observable>();
        observables.addAll(currWorkspace.getObservables()); 
        observables.add(slogoViewFrontEnd.getObservable());
        
        List<Observer> observers = new ArrayList<Observer>();
        observers.addAll(observerFactory.getObservers()); 
        observers.add(parser);
        /*6*/ HandleObservers.handleObservers(observables, observers);
        
        currWorkspace.startWorkspace();
        }
        catch(Exception e){
            e.printStackTrace();
            slogoViewFrontEnd.showError(e);
        }
        
        
        

//        manipulateController.setHeading(0);
//        manipulateController.foward(50);
        launch(args);
    }
}
