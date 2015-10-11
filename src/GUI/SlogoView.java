package GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;
import GUI.Button.ClearCommandButton;
import GUI.Button.EnterCommandButton;
import GUI.Button.HelpButton;
import GUI.TurtlePane.TurtlePane;
import GUI.ViewBox.CommandHistoryBox;
import GUI.ViewBox.FunctionListBox;
import GUI.ViewBox.VariableListBox;
import GUI.ViewBox.ViewBox;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SlogoView {

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private Scene scene;
    SlogoModel myModel;

    public SlogoView(String language){//, String classname) {
        // classname: passed to the 

        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);

        BorderPane root = new BorderPane();
        root.setMaxSize(1200, 700);
        //		String classname = null;

        root.setTop(menu()); // dropdowns, file, help
        root.setCenter(centerBox()); // turtle movement screen & boxes below it
        root.setRight(rightBox()); // variable, function, history
        root.setBottom(bottomBox());

        scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    }

    private Node bottomBox () {
        // TODO Auto-generated method stub
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
        result.getChildren().add(fileMenu());
        result.getChildren().add(languageDropDown());
        result.getChildren().add(bgColorDropDown());
        result.getChildren().add(penColorDropDown());
        result.getChildren().add(helpMenu());

        return result;
    }

    private Node fileMenu(){
        ComboBox<String> myComboBox = new ComboBox<String>();
        myComboBox.getItems().addAll("Get Image","Set Grid");
        myComboBox.setEditable(false);        
        myComboBox.promptTextProperty();
        myComboBox.setValue("File");
        return myComboBox;  

    }

    private Node helpMenu() {
        return new HelpButton("Help");
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
                                     "Spanish");
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
                                     "Red");
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
                                     "Red");
        myComboBox.setEditable(false);        
        myComboBox.promptTextProperty();
        myComboBox.setValue("Pen Color");

        return myComboBox;  
    }


    private VBox rightBox(){
        VBox result = new VBox();

        ViewBox v = new VariableListBox("variableList");
        v.addText("v1=4");

        ViewBox c = new CommandHistoryBox("commandHistoryList");
        //                c.addText("make: var1 = 4");

        ViewBox f = new FunctionListBox("functionList");
        //                f.addText("....");

        result.getChildren().addAll(v,c,f);
        return result;

    }

    private Node centerBox() {
        VBox result = new VBox();
        result.getChildren().add(turtleScreen());
        //		result.getChildren().add(messageAndClearBoxes());
        //		result.getChildren().add(commandAndEnterBoxes());
        return result;
    }



    private Node turtleScreen(){
//        Rectangle turtleBox = new Rectangle(100, 30, 800, 580);
//        turtleBox.toBack();
//        turtleBox.setFill(Color.LIGHTGREEN);
//        turtleBox.setStroke(Color.BLACK);
//        turtleBox.setStrokeWidth(2);
//        return turtleBox;	
        return new TurtlePane(800, 580);

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
        return new ClearCommandButton("Clear");
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
        return new EnterCommandButton("Enter");
    }

}
