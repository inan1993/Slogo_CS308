package GUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import GUI.button.AButton;
import GUI.button.ButtonFactory;
import GUI.checkbox.PenUpDownCheckBox;
import GUI.dropdown.BackgroundColorDropdown;
import GUI.dropdown.FileDropdown;
import GUI.dropdown.LanguageListDropdown;
import GUI.dropdown.LineTypeDropdown;
import GUI.dropdown.PenColorDropdown;
import GUI.slider.LineSlider;
import GUI.textBox.CommandPromptDisplayBox;
import GUI.textBox.MessageDisplayBox;
import GUI.turtlepane.BackgroundRectangle;
import GUI.turtlepane.TurtleCanvas;
import GUI.turtlepane.TurtleGroup;
import GUI.viewbox.CommandHistoryBox;
import GUI.viewbox.FunctionListBox;
import GUI.viewbox.TurtleStateBox;
import GUI.viewbox.VariableListBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sharedobjects.*;

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
    private TurtleStateBox turtleStateBox;
    private LineSlider lineSlider;
    private PenUpDownCheckBox checkBox;

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
        result.getChildren().addAll(createFileDropDown(),myButtons.get("UploadButton"),createLanguageDropDown(),bgColorDropDown(),penColorDropDown(),lineTypeDropDown(),myButtons.get("HelpButton"));

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
        ComboBox<String> fileDropDown = new FileDropdown();
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


    private Node lineTypeDropDown(){
        ComboBox<String> lineType = new LineTypeDropdown();
        lineType.setOnAction(event->{
            String line = lineType.getValue();
            myTurtleCanvas.setLineType(line);
            messageBox.setMessage("Line type set to "+line);
        });
        return lineType;  
    }

    private Node createLanguageDropDown(){
        ComboBox<String> languageDropDown = new LanguageListDropdown();
        languageDropDown.setOnAction(event->{
            String lang = languageDropDown.getValue();
            myUserInputObservable.setCurrentLanguage(lang);
            messageBox.setMessage("Language Set to "+lang);
        });
        return languageDropDown;  
    }

    private Node bgColorDropDown(){
        ComboBox<String> bgColor = new BackgroundColorDropdown();
        bgColor.setOnAction(event->{
            String color = bgColor.getValue();
            myBackgroundRectangle.setBackgroundColor(color);
            messageBox.setMessage("Background Color Set to "+color);
        });
        return bgColor;  
    }

    private Node penColorDropDown(){
        ComboBox<String> penColor = new PenColorDropdown();
        penColor.setOnAction(event->{
            String color = penColor.getValue();
            myTurtleCanvas.setPenColor(color);
            messageBox.setMessage("Pen Color Set to "+color);
        });
        return penColor;  
    }

    private Node centerBox() {
        TabPane tabPane = new TabPane();
        AnchorPane mainBox = new AnchorPane();
        //		TabPane mainBox = new TabPane();
        Tab tab = new Tab();
        myBackgroundRectangle = new BackgroundRectangle(Integer.parseInt(myResource.getString("canvasWidth")), Integer.parseInt(myResource.getString("canvasHeight")));
        myTurtleCanvas = new TurtleCanvas(Integer.parseInt(myResource.getString("canvasWidth")), Integer.parseInt(myResource.getString("canvasHeight")));
        myTurtleGroup = new TurtleGroup(myTurtleImage, myTurtleIDs);
        mainBox.getChildren().addAll(myBackgroundRectangle, myTurtleCanvas, myTurtleGroup);
        tab.setContent(mainBox);
        tab.setClosable(false);
        tab.setText("New Workspace");
        tabPane.getTabs().add(tab);
        return tabPane;
    }


    private Node messageAndClearBoxes(){
        HBox result = new HBox();
        result.getChildren().addAll(messageBox,myButtons.get("ClearCommandButton"),checkBox());
        return result;
    }


    private Node commandAndEnterBoxes() {
        HBox result = new HBox();
        result.getChildren().addAll(commandBox,myButtons.get("EnterCommandButton"),slider());
        return result;	
    }

    private HBox slider(){
        HBox slider = new HBox();
        lineSlider = new LineSlider();
        Label sliderCaption = new Label(" Pen thickness: ");
        lineSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sliderCaption.setText(" Pen thickness: "+ String.format("%.0f  ", newValue));		
                myTurtleCanvas.setPenWidth(newValue.doubleValue());
            }
        });
        slider.getChildren().addAll(lineSlider, sliderCaption);
        return slider;
    }

    private Node checkBox(){
        checkBox = new PenUpDownCheckBox();
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue ov, Boolean old_val, Boolean new_val) {
                messageBox.setMessage("Pen Down");

                myTurtleCanvas.penUpDown();
            }
        });

        return checkBox;
    }

    private VBox rightBox(){
        VBox result = new VBox();
        result.getChildren().addAll(variableDisplayBox,historyDisplayBox,functionDisplayBox,turtleStateBox);
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