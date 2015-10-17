package GUI;

import java.awt.Dimension;
import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;
import GUI.button.*;
import GUI.dropdown.*;
import GUI.textBox.*;
import GUI.turtlepane.*;
import GUI.viewbox.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class SlogoView {

	private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
	private Scene scene;
	private SlogoModel mySlogoModel;


	private String fileName;
	private CommandPromptDisplayBox commandBox; 
	private MessageDisplayBox messageBox;
	private AViewBox variableDisplayBox, historyDisplayBox, functionDisplayBox;
	private static Turtle turtle;
	private Map<String, ImageView> map;



	public SlogoView(String language){//, String classname) {

		ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		mySlogoModel = new SlogoModel();

		BorderPane root = new BorderPane();
		root.setMaxSize(1200, 700);

		root.setTop(menu()); // dropdowns, file, help
		root.setCenter(centerBox()); // turtle movement screen & boxes below it
		root.setRight(rightBox()); // variable, function, history
		root.setBottom(bottomBox());

		scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
	}

	private Node bottomBox () {
		VBox result = new VBox();
		result.getChildren().add(messageAndClearBoxes());
		result.getChildren().add(commandAndEnterBoxes());

		return result;
	}

	public Scene getScene(){
		return scene;
	}

	private Node menu() {
		HBox result = new HBox();
		result.getChildren().add(imageButton());
		result.getChildren().add(languageDropDown());
		result.getChildren().add(bgColorDropDown());
		result.getChildren().add(penColorDropDown());
		result.getChildren().add(helpMenu());
		return result;
	}

	private Node imageButton(){
		return new UploadButton(event->ButtonClicked());  
	}

	public void ButtonClicked() {

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		String label = null;

		if (selectedFile != null) {
			setFileName(selectedFile.getName());
			imageUpload(getFileName());
			System.out.println(getFileName());
		}

		else {
			if (selectedFile == null) {
				label = ("UploadCanceled");
				alert.setContentText(label);
				alert.showAndWait();
			}
		}
	}


	private void imageUpload(String name) {
		//

		//		new Turtle(name);
	}

	private Node helpMenu() {
		return new HelpButton();
	}

	private Node languageDropDown(){
		ComboBox<String> language = new LanguageListDropdown("Languages");
		language.setOnAction(event->{
			String lang = language.getValue();
			mySlogoModel.setLanguage(lang);
			messageBox.setMessage("Language Set to "+lang);
		});
		return language;  
	}

	private Node bgColorDropDown(){
		ComboBox<String> bgColor = new BackgroundColorDropdown("Background Color");
		bgColor.setOnAction(event->{
			String color = bgColor.getValue();
			mySlogoModel.setBackgroundColor(color);
			//draw();
			messageBox.setMessage("Background Color Set to "+color);
		});
		return bgColor;  
	}

	private Node penColorDropDown(){
		ComboBox<String> penColor = new PenColorDropdown("Pen Color");
		penColor.setOnAction(event->{
			String color = penColor.getValue();
			mySlogoModel.setPenColor(color);
			messageBox.setMessage("Pen Color Set to "+color);
		});
		return penColor;  
	}

	private VBox rightBox(){
		VBox result = new VBox();
		variableDisplayBox = new VariableListBox();
		historyDisplayBox = new CommandHistoryBox();
		functionDisplayBox = new FunctionListBox();

		result.getChildren().addAll(variableDisplayBox,historyDisplayBox,functionDisplayBox);
		return result;
	}

	private Node centerBox() {
		AnchorPane mainBox = new AnchorPane();

		//mainBox = new StackPane();
		TurtlePane canvas = new TurtlePane(800, 580);
		Group turtles = new Group();
	
		//turtles.getChildren().remove(index)
		turtle = new Turtle();
		turtle.drawTurtle();
		//turtle.drawLine();
		
		turtles.getChildren().add(turtle.getMyTurtle());
		turtle = new Turtle();
		turtle.drawTurtle2();

		turtles.getChildren().add(turtle.getMyTurtle());
		mainBox.getChildren().addAll(canvas, turtles);
		
		turtles.setTranslateX(45);
		turtles.setTranslateY(0);
		
		return mainBox;
	}


	private Node messageAndClearBoxes(){
		HBox result = new HBox();
		messageBox = new MessageDisplayBox();
		result.getChildren().add(messageBox);

		Button clearButton = new ClearCommandButton(event->{
			commandBox.clear();
		});
		result.getChildren().add(clearButton);
		return result;
	}


	private Node commandAndEnterBoxes() {
		HBox result = new HBox();
		commandBox = new CommandPromptDisplayBox();
		result.getChildren().add(commandBox);

		Button enterButton =  new EnterCommandButton(event->{
			mySlogoModel.addHistory(commandBox.getText());
			String str = commandBox.getText();
			messageBox.setMessage(str);
			historyDisplayBox.setMessage(str);
			//turtleMove();
		});

		result.getChildren().add(enterButton);
		return result;	
	}

	//	public void turtleMove(){
	//		//mainBox.setTranslateX(mainBox.getTranslateX()-40);
	//		//mainBox.setTranslateY(0);
	////		turtle.getMyTurtle().setVisible(false);
	//		turtle.getMyTurtle().setX(20);
	//		turtle.getMyTurtle().setY(10);
	//		turtle.drawTurtle();
	//		System.out.println("turtle moved");
	//
	//	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}