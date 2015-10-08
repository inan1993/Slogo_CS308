package GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	private TextArea function;
	private TextArea variable;
	private TextArea history;
	
	public SlogoView(String language){//, String classname) {
		// classname: passed to the 

		ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

		BorderPane root = new BorderPane();
		String classname = null;
		//enableButtons(classname);

		root.setBottom(makeCommand()); // command entry, enter, clear, message box
		root.setCenter(turtleScreen(classname)); // turtle movement screen
		root.setRight(variableBox(classname)); // variable, function, history
		root.setTop(makeInputPanel());

		scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

	}

	public Scene getScene(){
		return scene;
	}

	private Node makeInputPanel() {
		VBox result = new VBox();
		result.getChildren().addAll(menuBars());
		result.getChildren().add(dropDown());
		return result;
	}

	private Node makeCommand(){
		VBox result = new VBox();
		result.getChildren().add(commandBox());
		result.getChildren().add(commandBoxMenu());
		return result;
	}
	
	
	private VBox variableBox(String classname){
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

	private Node commandBox(){//String classname){
		TextArea textArea = new TextArea();
		textArea.setText("command world");
		return textArea;

	}

	private Node turtleScreen(String classname){
		TextArea textArea = new TextArea();
		textArea.setText("turtle world");

		return textArea;		

	}

	private Node commandBoxMenu(){
		HBox result = new HBox();
		clearButton = new Button("Clear");//"FileCommand", new EventHandler<ActionEvent>() {
		result.getChildren().add(clearButton);

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

	
	private Node dropDown(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
		            "Color",
		            "Size",
		            "Image"
		);
		myComboBox.setPromptText("Components");
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("Color");

		return myComboBox;  
	}

}
