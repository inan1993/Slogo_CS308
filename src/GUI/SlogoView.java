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
import GUI.button.*;
import GUI.dropdown.*;
import GUI.textBox.*;
import GUI.turtlepane.*;
import GUI.viewbox.*;
import datatransferobjects.UserInputTransferObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
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

    private HashMap<String, AButton> myButtons;

    public SlogoView(){

        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + DEFAULT_LANGUAGE);
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_VIEW);

        myButtons = new HashMap<String, AButton>();
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

    
    private void clearButtonEvent(){
        commandBox.clear();
    }
    private void uploadButtonEvent() {
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
    private void enterButtonEvent(){
        String userInput = commandBox.getText();
        historyDisplayBox.setMessage(userInput);
        myUserInputObservable.setUserInput(userInput);
        UserInputTransferObject ut = new UserInputTransferObject(myUserInputObservable.getCurrentLanguage(), myUserInputObservable.getUserInput());
        myUserInputObservable.notifyObservers(ut);
    }
    private void helpButtonEvent() {
        try {
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/commands.php").toURI());
        } catch (Exception e) {};
    }
 
    
    private void mapButtonsWithActions(){
        String[] buttons = myResource.getString("buttons").split(",");
        HashMap<String, EventHandler<ActionEvent>> buttonEventHandle = new HashMap<String, EventHandler<ActionEvent>>();
        //Help, Enter, Clear, Upload
        buttonEventHandle.put(buttons[0], event->helpButtonEvent());
        buttonEventHandle.put(buttons[1], event->enterButtonEvent());
        buttonEventHandle.put(buttons[2], event->clearButtonEvent());
        buttonEventHandle.put(buttons[3], event->uploadButtonEvent());
        for(String buttonClassName: buttons){
            try {
                Constructor<?> c =
                        Class.forName("GUI.button."+buttonClassName)
                        .getConstructor(EventHandler.class);
//                AButton button = (AButton) c.newInstance(new EventHandler<ActionEvent>() {
//                    @Override public void handle(ActionEvent e) {
//                        help();
//                    }
//                });
                AButton button = (AButton) c.newInstance(buttonEventHandle.get(buttonClassName));
                myButtons.put(buttonClassName, button);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private Node menu() {
        HBox result = new HBox();
        result.getChildren().add(createFileDropDown());
        result.getChildren().add(myButtons.get("UploadButton"));
        result.getChildren().add(createLanguageDropDown());
        result.getChildren().add(bgColorDropDown());
        result.getChildren().add(penColorDropDown());
        result.getChildren().add(lineTypeDropDown());
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

	private Node createFileDropDown(){
	ComboBox<String> fileDropDown = new FileDropDown("File");
	fileDropDown.setOnAction(event->{
		String text = fileDropDown.getValue();
		if(text.equalsIgnoreCase("New Workspace")){
			//centerBox();
		}else if(text.equalsIgnoreCase("Save Workspace")){
			//centerBox();
		}
		messageBox.setMessage(text + " executed");
	});
	return fileDropDown;  
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

    private Node lineTypeDropDown(){
		ComboBox<String> lineType = new LineTypeDropDown("Line Type");
		lineType.setOnAction(event->{
			String line = lineType.getValue();
			myTurtleCanvas.setLineType(line);
			messageBox.setMessage("Line type set to "+line);
		});
		return lineType;  
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
        result.getChildren().add(myButtons.get("ClearCommandButton"));
        return result;
    }

    
    private Node commandAndEnterBoxes() {
        HBox result = new HBox();
        commandBox = new CommandPromptDisplayBox();
        result.getChildren().add(commandBox);
        result.getChildren().add(myButtons.get("EnterCommandButton"));
        return result;	
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

}