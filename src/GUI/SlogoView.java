package GUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import GUI.button.AButton;
import GUI.button.ButtonFactory;
import GUI.dropdown.BackgroundColorDropdown;
import GUI.dropdown.LanguageListDropdown;
import GUI.dropdown.PenColorDropdown;
import GUI.textBox.CommandPromptDisplayBox;
import GUI.textBox.MessageDisplayBox;
import GUI.turtlepane.BackgroundRectangle;
import GUI.turtlepane.TurtleCanvas;
import GUI.turtlepane.TurtleGroup;
import GUI.viewbox.CommandHistoryBox;
import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import observers.FrontEndObserver;
import observers.ParsedCommandsObserver;
import sharedobjects.UserInput;

public class SlogoView {

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
//    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final String DEFAULT_RESOURCE_VIEW = "GUI.view";
    protected static ResourceBundle myResource;

    private static final String DEFAULT_LANGUAGE = "English";

    private Scene scene;


    private CommandPromptDisplayBox commandBox; 
    private MessageDisplayBox messageBox;
    private VariableListBox variableDisplayBox;
    private CommandHistoryBox historyDisplayBox;
    private FunctionListBox functionDisplayBox;

    private Image myTurtleImage;
    private List<Double> myTurtleIDs;
    private TurtleCanvas myTurtleCanvas;
    private TurtleGroup myTurtleGroup;
    private BackgroundRectangle myBackgroundRectangle;

    private UserInput myUserInputObservable;

    private Map<String, AButton> myButtons;

    public SlogoView(){

//        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + DEFAULT_LANGUAGE);
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_VIEW);
        commandBox = new CommandPromptDisplayBox();
        messageBox = new MessageDisplayBox();
        variableDisplayBox = new VariableListBox(commandBox);
        historyDisplayBox = new CommandHistoryBox(commandBox);
        functionDisplayBox = new FunctionListBox(commandBox);
        myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle")));
        myTurtleIDs = new ArrayList<Double>();
        myTurtleGroup = new TurtleGroup(myTurtleImage, myTurtleIDs);
        myUserInputObservable = new UserInput(DEFAULT_LANGUAGE);
        
        ButtonFactory buttonFactory = new ButtonFactory(commandBox, messageBox, historyDisplayBox, myTurtleGroup, myUserInputObservable);
        myButtons = buttonFactory.getButtons();

        BorderPane root = new BorderPane();

        root.setMaxSize(DEFAULT_SIZE.getWidth(),DEFAULT_SIZE.getHeight());

        root.setTop(menu());
        root.setCenter(centerBox());
        root.setBottom(bottomBox());
        root.setRight(rightBox());    

        //    myObservers.get(0).update(null, (Object)createDTO());
        //myObservers.get(0).update(null, (Object)createDTO2());
        scene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    }

    
    private Node menu() {
        HBox result = new HBox();
        result.getChildren().add(myButtons.get("UploadButton"));
        result.getChildren().add(createLanguageDropDown());
        result.getChildren().add(bgColorDropDown());
        result.getChildren().add(penColorDropDown());
        result.getChildren().add(myButtons.get("HelpButton"));
        return result;
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


    private Node createLanguageDropDown(){
        ComboBox<String> languageDropDown = new LanguageListDropdown("Languages");
        languageDropDown.setOnAction(event->{
            String lang = languageDropDown.getValue();
            myUserInputObservable.setCurrentLanguage(lang);
            messageBox.setMessage("Language Set to "+lang);
        });
        return languageDropDown;  
    }

    private Node bgColorDropDown(){
        ComboBox<String> bgColor = new BackgroundColorDropdown("Background Color");
        bgColor.setOnAction(event->{
            String color = bgColor.getValue();
            myBackgroundRectangle.setBackgroundColor(color);
            messageBox.setMessage("Background Color Set to "+color);
        });
        return bgColor;  
    }

    private Node penColorDropDown(){
        ComboBox<String> penColor = new PenColorDropdown("Pen Color");
        penColor.setOnAction(event->{
            String color = penColor.getValue();
            myTurtleCanvas.setPenColor(color);
            messageBox.setMessage("Pen Color Set to "+color);
        });
        return penColor;  
    }


    private Node centerBox() {
        AnchorPane mainBox = new AnchorPane();
        myBackgroundRectangle = new BackgroundRectangle(Integer.parseInt(myResource.getString("canvasWidth")), Integer.parseInt(myResource.getString("canvasHeight")));
        myTurtleCanvas = new TurtleCanvas(Integer.parseInt(myResource.getString("canvasWidth")), Integer.parseInt(myResource.getString("canvasHeight")));
        mainBox.getChildren().addAll(myBackgroundRectangle, myTurtleCanvas, myTurtleGroup);
        return mainBox;
    }


    private Node messageAndClearBoxes(){
        HBox result = new HBox();
        result.getChildren().add(messageBox);
        result.getChildren().add(myButtons.get("ClearCommandButton"));
        return result;
    }


    private Node commandAndEnterBoxes() {
        HBox result = new HBox();
        result.getChildren().add(commandBox);
        result.getChildren().add(myButtons.get("EnterCommandButton"));
        return result;	
    }



    private VBox rightBox(){
        VBox result = new VBox();
        result.getChildren().addAll(variableDisplayBox,historyDisplayBox,functionDisplayBox);
        return result;
    }
   
    
    public Observable getObservable(){
        return this.myUserInputObservable;
    }


    public TurtleGroup getTurtlePaneGroup () {
        return myTurtleGroup;
    }

    public TurtleCanvas getTurtlePaneCanvas () {
        return myTurtleCanvas;
    }


    public FunctionListBox getFunctionDisplayBox () {
        return functionDisplayBox;
    }


    public VariableListBox getVariableDisplayBox () {
        return variableDisplayBox;
    }
}