package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.GUI.SlogoModel;
import src.GUI.SlogoView;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    Scene scene;
	
	public  void start (Stage stage) throws Exception {
        SlogoModel model = new SlogoModel();
        SlogoView display = new SlogoView(model, "English");
        stage.setTitle(TITLE);
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show();
       
    }
	
    public static void main (String[] args) {
        launch(args);
    }

	

}
