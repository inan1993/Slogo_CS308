package GUI;

import java.awt.Dimension;
import java.util.ResourceBundle;
import GUI.Button.ClearCommandButton;
import GUI.Button.EnterCommandButton;
import GUI.Button.HelpButton;
import GUI.Dropdown.BackgroundColorDropdown;
import GUI.Dropdown.LanguageListDropdown;
import GUI.Dropdown.PenColorDropdown;
import GUI.TextBox.CommandPromptDisplayBox;
import GUI.TextBox.MessageDisplayBox;
import GUI.TextBox.TextDisplayBox;
import GUI.TurtlePane.TurtlePane;
import GUI.ViewBox.CommandHistoryBox;
import GUI.ViewBox.FunctionListBox;
import GUI.ViewBox.VariableListBox;
import GUI.ViewBox.ViewBox;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SlogoView {

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private SlogoModel mySlogoModel;

    private TextDisplayBox commandBox, messageBox;


    public SlogoView(String language){//, String classname) {

        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        mySlogoModel = new SlogoModel();

        BorderPane root = new BorderPane();
        root.setMaxSize(DEFAULT_SIZE.getHeight(), DEFAULT_SIZE.getWidth());

        root.setTop(menu()); // dropdowns, file, help
        root.setCenter(centerBox()); // turtle movement screen & boxes below it
        root.setRight(rightBox()); // variable, function, history
        root.setBottom(bottomBox());


    }

    private Node bottomBox () {
        VBox result = new VBox();
        result.getChildren().add(messageAndClearBoxes());
        result.getChildren().add(commandAndEnterBoxes());

        return result;
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
        ViewBox v = new VariableListBox("variableList");
        ViewBox c = new CommandHistoryBox("commandHistoryList");
        ViewBox f = new FunctionListBox("functionList");
        result.getChildren().addAll(v,c,f);
        return result;
    }

    private Node centerBox() {
        return new TurtlePane(800, 580, mySlogoModel);
    }



    private Node messageAndClearBoxes(){
        HBox result = new HBox();
        messageBox = new MessageDisplayBox();
        result.getChildren().add(messageBox);

        Button clearButton = new ClearCommandButton();
        clearButton.setOnAction(event->{
            commandBox.clear();
        });
        result.getChildren().add(clearButton);
        return result;
    }


    private Node commandAndEnterBoxes() {
        HBox result = new HBox();
        commandBox = new CommandPromptDisplayBox();
        result.getChildren().add(commandBox);

        Button enterButton =  new EnterCommandButton();
        enterButton.setOnAction(event->{
            mySlogoModel.addHistory(commandBox.getText());
        });
        result.getChildren().add(enterButton);
        return result;	
    }
}
