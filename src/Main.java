package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.GUI.SlogoModel;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    Scene scene;
	
	public  void start (Stage stage) throws Exception {
        SlogoModel model = new SlogoModel();
        //SlogoView display = new SlogoView(model, "English");
        stage.setTitle(TITLE);
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show();
        //display.showScene;
        
    }
	
    public static void main (String[] args) {
        launch(args);
    }

	

}
