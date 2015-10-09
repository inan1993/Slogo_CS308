package GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SlogoView {

	public static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
	private Scene scene;
	SlogoModel myModel;

	private Button fileButton;
	private Button languageButton;
	private Button helpButton;
	private Button clearButton;
	private Button enterButton;
	private TextArea function;
	private TextArea variable;
	private TextArea history;

	public SlogoView(String language){//, String classname) {
		// classname: passed to the 

		ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

		BorderPane root = new BorderPane();
//		String classname = null;

		//root.setBottom(messageBox()); // command entry, enter, clear, message box
		root.setCenter(centerBox()); // turtle movement screen & boxes below it
		root.setRight(rightBox()); // variable, function, history
		root.setTop(menu());

		scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

	}

	public Scene getScene(){
		return scene;
	}
	
	private Node menu() {
		HBox result = new HBox();
		result.getChildren().addAll(menuBars());
		result.getChildren().add(bgColorDropDown());
		return result;
	}

	
	private Node menuBars () {
		HBox result = new HBox();
		fileButton = new Button("File");//"FileCommand", new EventHandler<ActionEvent>() {
		fileButton.setMaxWidth(200);
		result.getChildren().add(fileButton);
		languageButton = new Button("Language");//, event -> language());
		result.getChildren().add(languageButton);
		helpButton = new Button("Help");//makeButton("HelpCommand", event -> help());
		result.getChildren().add(helpButton);

		return result;
	}


	private Node bgColorDropDown(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
				"White",
				"Black",
				"Green"
				);
		myComboBox.setPromptText("Components");
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("Color");

		return myComboBox;  
	}

	

	private Node makeCommand(){
		VBox result = new VBox();
		result.getChildren().add(commandBox());
		result.getChildren().add(commandBoxMenu());
		return result;
	}


	private Node commandBoxMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	private VBox rightBox(){
		VBox result = new VBox();
		function = new TextArea();
		function.setText("function world");
		result.getChildren().add(function);

		variable = new TextArea();
		variable.setText("variable world");
		result.getChildren().add(variable);

		history = new TextArea();
		history.setText("history world");
		result.getChildren().add(history);
		return result;

	}

	private Node centerBox() {
		VBox result = new VBox();
		result.getChildren().add(turtleScreen());
		result.getChildren().add(messageAndClearBoxes());
		result.getChildren().add(commandAndEnterBoxes());
		return result;
	}



	private Node turtleScreen(){
		TextArea textArea = new TextArea();
		textArea.setText("turtle world");

		return textArea;		

	}


	private Node messageAndClearBoxes(){
		HBox result = new HBox();
		result.getChildren().add(messageBox());
		result.getChildren().add(clearBox());
		return result;
	}
	
	private Node messageBox(){
		Label label = new Label("hello");
		return label;
	}

	private Node clearBox(){
		clearButton = new Button("Clear");//"FileCommand", new EventHandler<ActionEvent>() {
//		result.getChildren().add(clearButton);

		return clearButton;
	}


	private Node commandAndEnterBoxes() {
		HBox result = new HBox();
		result.getChildren().add(commandBox());
		result.getChildren().add(enterBox());
		return result;	}

	private Node commandBox(){//String classname){
		TextArea textArea = new TextArea();
		textArea.setText("Enter command here");
		return textArea;

	}

	private Node enterBox(){
		enterButton = new Button("Enter");
		return enterButton;
	}
	
}
