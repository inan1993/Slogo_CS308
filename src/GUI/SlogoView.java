package GUI;

import java.awt.Desktop;
import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SlogoView {

	private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
	private Scene scene;
	SlogoModel myModel;

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
		root.setMaxSize(1200, 700);
		//		String classname = null;

		root.setTop(menu()); // dropdowns, file, help
		root.setCenter(centerBox()); // turtle movement screen & boxes below it
		root.setRight(rightBox()); // variable, function, history

		scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

	}

	public Scene getScene(){
		return scene;
	}

	private Node menu() {
		HBox result = new HBox();
		result.getChildren().add(fileMenu());
		result.getChildren().add(languageDropDown());
		result.getChildren().add(bgColorDropDown());
		result.getChildren().add(penColorDropDown());
		result.getChildren().add(helpMenu());

		return result;
	}

	private Node fileMenu(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
				"Get Image",
				"Set Grid"
				);
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("File");
		return myComboBox;  

	}

	private Node helpMenu() {
		helpButton = new Button("Help");//makeButton("HelpCommand", event -> help());
		helpButton.setPrefWidth(100);
		helpButton.addEventHandler(ActionEvent.ACTION, event -> help());

		return helpButton;
	}

	private void help() {
		try {
			Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/").toURI());
		} catch (Exception e) {};
	}

	private Node languageDropDown(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
				"Chinese",
				"English",
				"French",
				"German",
				"Italian",
				"Portugese",
				"Russian",
				"Spanish"
				);
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("Language");

		return myComboBox;  
	}

	private Node bgColorDropDown(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
				"White",
				"Black",
				"Green",
				"Yellow",
				"Red"
				);
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("Background Color");

		return myComboBox;  
	}

	private Node penColorDropDown(){
		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll(
				"White",
				"Black",
				"Green",
				"Yellow",
				"Red"
				);
		myComboBox.setEditable(false);        
		myComboBox.promptTextProperty();
		myComboBox.setValue("Pen Color");

		return myComboBox;  
	}


	private VBox rightBox(){
		VBox result = new VBox();
		function = new TextArea();
		function.setText("function world");
		function.setPrefSize(400, 270);
		function.setStyle("-fx-border-color: black;");
		result.getChildren().add(function);

		variable = new TextArea();
		variable.setText("variable world");
		variable.setPrefSize(400, 200);
		variable.setStyle("-fx-border-color: black;");
		result.getChildren().add(variable);

		history = new TextArea();
		history.setText("history world");
		history.setPrefSize(400, 200);
		history.setStyle("-fx-border-color: black;");
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
		Rectangle turtleBox = new Rectangle(100, 30, 800, 580);
		turtleBox.toBack();
		turtleBox.setFill(Color.LIGHTGREEN);
		turtleBox.setStroke(Color.BLACK);
		turtleBox.setStrokeWidth(2);
		return turtleBox;		

	}


	private Node messageAndClearBoxes(){
		HBox result = new HBox();
		result.getChildren().add(messageBox());
		result.getChildren().add(clearBox());
		return result;
	}

	private Node messageBox(){
		Label label = new Label("Message will be displayed here");
		label.setPrefSize(650,30);
		label.setTextFill(Color.RED);
		label.setWrapText(true);
		label.setStyle("-fx-border-color: red;");
		return label;
	}

	private Node clearBox(){
		clearButton = new Button("Clear");
		clearButton.setPrefWidth(155);
		clearButton.setStyle("-fx-border-color: black;");

		return clearButton;
	}


	private Node commandAndEnterBoxes() {
		HBox result = new HBox();
		result.getChildren().add(commandBox());
		result.getChildren().add(enterBox());
		return result;	
	}

	private Node commandBox(){
		TextArea textArea = new TextArea();
		textArea.setPromptText("Enter command here");
		textArea.setPrefSize(650, 70);
		textArea.setStyle("-fx-border-color: black;");
		return textArea;

	}

	private Node enterBox(){
		enterButton = new Button("Enter");
		enterButton.setPrefSize(155, 70);
		enterButton.setStyle("-fx-border-color: black;");
		return enterButton;
	}

}
