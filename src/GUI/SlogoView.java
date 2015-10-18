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

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 700);
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final String DEFAULT_RESOURCE_VIEW = "GUI.view";
    protected static ResourceBundle myResource;

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
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_VIEW);

        myTurtleImage = new Image(getClass().getClassLoader().getResourceAsStream(myResource.getString("defaultTurtle")));
        myTurtleIDs = new ArrayList<Double>();
        myObservers = new ArrayList<Observer>();

        BorderPane root = new BorderPane();

        root.setMaxSize(DEFAULT_SIZE.getWidth(),DEFAULT_SIZE.getHeight());

        root.setTop(menu());
        root.setCenter(centerBox());
        root.setBottom(bottomBox());
        root.setRight(rightBox());    
        
        myObservers.get(0).update(null, (Object)createDTO());
        //myObservers.get(0).update(null, (Object)createDTO2());
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
        String fileName;

        if (selectedFile != null) {
            fileName = selectedFile.getName();
            myTurtleGroup.setImage(new Image(getClass().getClassLoader().getResourceAsStream(fileName)));
            System.out.println(fileName);
            myObservers.get(0).update(null, (Object)createDTO2());
        }
        else {
            if (selectedFile == null) {
                messageBox.setMessage("Upload Cancelled");
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
        TurtleTransferObject turtle = new TurtleTransferObject(false, 1, true, true, new int[]{10,50}, new int[]{200,200});
        return turtle;
    }
    public TurtleTransferObject createDTO2(){
        TurtleTransferObject turtle = new TurtleTransferObject(false, 1, true, true, new int[]{50,55}, new int[]{20,20});
        return turtle;
    }
    
}