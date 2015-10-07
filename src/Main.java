
import GUI.SlogoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static final String TITLE = "Slogo";
    Scene scene;
	
	public  void start (Stage stage) throws Exception {
        //SlogoModel model = new SlogoModel();
        SlogoView display = new SlogoView("English");
        stage.setTitle(TITLE);
        stage.setScene(display.getScene()); 
        stage.sizeToScene(); 
        stage.show();

        
    }
	
    public static void main (String[] args) {
        launch(args);
    }

	

}
