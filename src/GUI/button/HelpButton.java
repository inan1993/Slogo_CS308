package GUI.button;

import java.awt.Desktop;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HelpButton extends AButton{

    public HelpButton (){//EventHandler<ActionEvent> event) {
        super("Help");
        this.addEventHandler(ActionEvent.ACTION, event -> help());
    }
    private void help() {
        try {
            Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/fall15/compsci308/assign/03_slogo/commands.php").toURI());
        } catch (Exception e) {};
    }
}
