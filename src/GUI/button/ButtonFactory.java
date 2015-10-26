package GUI.button;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import GUI.textBox.CommandPromptDisplayBox;
import GUI.textBox.MessageDisplayBox;
import GUI.turtlepane.TurtleGroup;
import GUI.viewbox.CommandHistoryBox;
import datatransferobjects.UserInputTransferObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import sharedobjects.UserInput;

public class ButtonFactory {
    private static final String DEFAULT_RESOURCE_BUTTON = "GUI.button.buttons";
    protected static ResourceBundle myResource;

    private Map<String, AButton> myButtons;
    private CommandPromptDisplayBox myCommandBox; 
    private MessageDisplayBox myMessageBox;
    private CommandHistoryBox myHistoryDisplayBox;
    private TurtleGroup myTurtleGroup;
    private UserInput myUserInputObservable;
    
    public ButtonFactory (CommandPromptDisplayBox commandBox, MessageDisplayBox messageBox, CommandHistoryBox historyDisplayBox, TurtleGroup turtleGroup, UserInput userInputObservable) {
        myResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_BUTTON);
        this.myCommandBox = commandBox;
        this.myHistoryDisplayBox = historyDisplayBox;
        this.myMessageBox = messageBox;
        this.myTurtleGroup = turtleGroup;
        this.myUserInputObservable = userInputObservable;
        myButtons = new HashMap<String, AButton>();
        createButtons();
    }
    
    public void createButtons(){
        String[] buttons = myResource.getString("buttons").split(",");
        HashMap<String, EventHandler<ActionEvent>> buttonEventHandle = new HashMap<String, EventHandler<ActionEvent>>();
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
    
    
    public Map<String, AButton> getButtons(){
        return myButtons;
    }
    
    private void clearButtonEvent(){
        myCommandBox.clear();
    }
    private void uploadButtonEvent() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        String fileName;
        
        if (selectedFile != null) {
            fileName = selectedFile.getName();
            myTurtleGroup.setImage(new Image(getClass().getClassLoader().getResourceAsStream(fileName)));
            //            myObservers.get(0).update(null, (Object)createDTO2());
            myMessageBox.setMessage(fileName + " uploaded");//System.out.println("uploaded");
        }
        else {
            if (selectedFile == null) {
                myMessageBox.setMessage("Upload Cancelled");
            }
        }
    }
    private void enterButtonEvent(){
        String userInput = myCommandBox.getText();
        myHistoryDisplayBox.setMessage(userInput);
        myUserInputObservable.setUserInput(userInput);
        UserInputTransferObject ut = new UserInputTransferObject(myUserInputObservable.getCurrentLanguage(), myUserInputObservable.getUserInput());
        myUserInputObservable.notifyObservers(ut);
    }
    private void helpButtonEvent() {
        try {
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/commands.php").toURI());
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/commands2.php").toURI());
        } catch (Exception e) {};
    }

}
