
import GUI.SlogoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

    	/*1*/Workspace currWorkspace = new Workspace(); //TODO: workspace must create an observables list
    	/*2*/ManipulateController manipulateController = new ManipulateController(currWorkspace);
    	
    	///*3*/Executor executor = new Executor(manipulateController);
    	///*4*/Parser parser = new Parser(executor, manipulateController);
    	
    	/*5*/ frontEnd = new SlogoView(); //TODO: frontEnd must create an observers list
      
    	/*6*/ HandleObservers.handleObservers(currWorkspace.getObservables(), frontEnd.getObservers());
    	
    	currWorkspace.startWorkspace();
    	manipulateController.setHeading(0);
    	manipulateController.foward(50);
        launch(args);
    }
}
