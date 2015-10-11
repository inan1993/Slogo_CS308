package GUI.Button;

import java.awt.Desktop;
import java.net.URL;
import javafx.event.ActionEvent;

public class HelpButton extends Buttons{

    public HelpButton (String text) {
        super(text);
        this.addEventHandler(ActionEvent.ACTION, event -> help());
    }

    private void help() {
        try {
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/").toURI());
        } catch (Exception e) {};
    }
    
}
