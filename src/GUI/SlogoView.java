package GUI;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import org.w3c.dom.Element;
import GUI.button.AButton;
import GUI.button.ClearCommandButton;
import GUI.button.EnterCommandButton;
import GUI.button.UploadButton;
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
import datatransferobjects.UserInputTransferObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import observers.FrontEndObserver;
import observers.ParsedCommandsObserver;
import sharedobjects.UserInput;

public class SlogoView {

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
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

    private List<Observer> myObservers;
    private UserInput myUserInputObservable;

    private HashMap<String, EventHandler<ActionEvent>> myButtonActions;

    public SlogoView(){

        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + DEFAULT_LANGUAGE);
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_VIEW);

        mapButtonsWithActions();



        myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle")));
        myTurtleIDs = new ArrayList<Double>();
        myObservers = new ArrayList<Observer>();

        myUserInputObservable = new UserInput(DEFAULT_LANGUAGE);

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

    private void mapButtonsWithActions(){
        String[] buttons = myResource.getString("buttons").split(",");
        myButtonActions = new HashMap<String, EventHandler<ActionEvent>>();
        //Help, Enter, Clear, Upload

        try {
            Constructor<?> c =
                    Class.forName(buttons[0])
                    .getConstructor(EventHandler.class);
            AButton button = c.newInstance(event->help());
        }catch(Exception e){
            
        }


        myButtonActions.put(buttons[0], event->help());
        myButtonActions.put(buttons[1], event->enterEvent());
        myButtonActions.put(buttons[2], event->{
            commandBox.clear();
        });
        myButtonActions.put(buttons[3], event->uploadEvent());
    }

    private Node menu() {
        HBox result = new HBox();
        result.getChildren().add(imageButton());
        result.getChildren().add(createLanguageDropDown());
        result.getChildren().add(bgColorDropDown());
        result.getChildren().add(penColorDropDown());
        //        result.getChildren().add(createHelpMenu());
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


    private Node imageButton(){
        return new UploadButton(event->uploadEvent());  
    }

    public void uploadEvent() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        String fileName;

        if (selectedFile != null) {
            fileName = selectedFile.getName();
            myTurtleGroup.setImage(new Image(getClass().getClassLoader().getResourceAsStream(fileName)));
            //            myObservers.get(0).update(null, (Object)createDTO2());
        }
        else {
            if (selectedFile == null) {
                messageBox.setMessage("Upload Cancelled");
            }
        }
    }

    //    private Node createHelpMenu() {
    //        return new HelpButton();
    //    }

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
        myTurtleGroup = new TurtleGroup(myTurtleImage, myTurtleIDs);
        myObservers.add(new FrontEndObserver(myTurtleGroup, myTurtleCanvas));

        mainBox.getChildren().addAll(myBackgroundRectangle, myTurtleCanvas, myTurtleGroup);
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

        Button enterButton =  new EnterCommandButton(event->enterEvent());

        result.getChildren().add(enterButton);
        return result;	
    }

    private void enterEvent(){
        String userInput = commandBox.getText();
        historyDisplayBox.setMessage(userInput);
        myUserInputObservable.setUserInput(userInput);
        UserInputTransferObject ut = new UserInputTransferObject(myUserInputObservable.getCurrentLanguage(), myUserInputObservable.getUserInput());
        myUserInputObservable.notifyObservers(ut);
    }


    private VBox rightBox(){
        VBox result = new VBox();
        variableDisplayBox = new VariableListBox(commandBox);
        historyDisplayBox = new CommandHistoryBox(commandBox);
        functionDisplayBox = new FunctionListBox(commandBox);
        myObservers.add(new ParsedCommandsObserver(functionDisplayBox, variableDisplayBox));
        result.getChildren().addAll(variableDisplayBox,historyDisplayBox,functionDisplayBox);
        return result;
    }

    public List<Observer> getObservers(){
        return this.myObservers;
    }

    public void addObservers(Observer obs){
        myObservers.add(obs);
    }

    public Observable getObservable(){
        return this.myUserInputObservable;
    }

    private void help() {
        try {
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/commands.php").toURI());
        } catch (Exception e) {};
    }

}