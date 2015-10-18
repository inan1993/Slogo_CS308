package GUI;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.ResourceBundle;
import GUI.button.ClearCommandButton;
import GUI.button.EnterCommandButton;
import GUI.button.HelpButton;
import GUI.button.UploadButton;
import GUI.dropdown.BackgroundColorDropdown;
import GUI.dropdown.LanguageListDropdown;
import GUI.dropdown.PenColorDropdown;
import GUI.textBox.CommandPromptDisplayBox;
import GUI.textBox.MessageDisplayBox;
import GUI.turtlepane.BackgroundRectangle;
import GUI.turtlepane.TurtleCanvas;
import GUI.turtlepane.TurtleGroup;
import GUI.viewbox.AViewBox;
import GUI.viewbox.CommandHistoryBox;
import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import datatransferobjects.TurtleTransferObject;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import observers.FrontEndObserver;

public class SlogoView {

    //TODO Put default size in properties file.
    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final String DEFAULT_TURTLE_IMAGE = "turtle1.png";
    private static final String DEFAULT_LANGUAGE = "English";

    private Scene scene;


    private CommandPromptDisplayBox commandBox; 
    private MessageDisplayBox messageBox;
    private AViewBox variableDisplayBox, historyDisplayBox, functionDisplayBox;
    
    private Image myTurtleImage;
    private List<Double> myTurtleIDs;
    private TurtleCanvas myTurtleCanvas;
    private TurtleGroup myTurtleGroup;
    private BackgroundRectangle myBackgroundRectangle;
    
    private List<Observer> myObservers;

    public SlogoView(){

        ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + DEFAULT_LANGUAGE);

//TODO Put default image in properties file.
        myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(DEFAULT_TURTLE_IMAGE));
        myTurtleIDs = new ArrayList<Double>();
        myObservers = new ArrayList<Observer>();

        BorderPane root = new BorderPane();

//TODO Put default image in properties file.
        root.setMaxSize(DEFAULT_SIZE.getWidth(),DEFAULT_SIZE.getHeight());

        root.setTop(menu());
        root.setCenter(centerBox());
        root.setBottom(bottomBox());
        root.setRight(rightBox());
        
        
        myObservers.get(0).update(null, (Object)createDTO());
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
        result.getChildren().add(createLanguageDropDown());
        result.getChildren().add(bgColorDropDown());
        result.getChildren().add(penColorDropDown());
        result.getChildren().add(createHelpMenu());
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
        String fileName;

        if (selectedFile != null) {
            fileName = selectedFile.getName();
            myTurtleGroup.setImage(new Image(getClass().getClassLoader().getResourceAsStream(fileName)));
            System.out.println(fileName);
        }
        else {
            if (selectedFile == null) {
                alert.setContentText("Upload Canceled");
                alert.showAndWait();
            }
        }
    }

    private Node createHelpMenu() {
        return new HelpButton();
    }

    private Node createLanguageDropDown(){
        ComboBox<String> languageDropDown = new LanguageListDropdown("Languages");
        languageDropDown.setOnAction(event->{
            String lang = languageDropDown.getValue();
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
        StackPane mainBox = new StackPane();//AnchorPane mainBox = new AnchorPane();

// TODO add to properties
        myBackgroundRectangle = new BackgroundRectangle(800, 580);
        myTurtleCanvas = new TurtleCanvas(800, 580);
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

        Button enterButton =  new EnterCommandButton(event->{
            String str = commandBox.getText();
            messageBox.setMessage(str);
            historyDisplayBox.setMessage(str);
        });

        result.getChildren().add(enterButton);
        return result;	
    }
    

    private VBox rightBox(){
        VBox result = new VBox();
        variableDisplayBox = new VariableListBox(commandBox);
        historyDisplayBox = new CommandHistoryBox(commandBox);
        functionDisplayBox = new FunctionListBox(commandBox);

        result.getChildren().addAll(variableDisplayBox,historyDisplayBox,functionDisplayBox);
        return result;
    }
    
    public List<Observer> getObservers(){
        return this.myObservers;
    }
    
    public void addObservers(Observer obs){
        myObservers.add(obs);
    }
    
    
    public TurtleTransferObject createDTO(){
        TurtleTransferObject turtle = new TurtleTransferObject(false, 1, true, true, new int[]{0,0}, new int[]{20,20});
        return turtle;
    }
    
}