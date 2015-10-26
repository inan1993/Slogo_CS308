package GUI.viewbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import datatransferobjects.TurtleTransferObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

public class TurtleStateBox extends TitledPane {

    private ObservableList<String> turtleData;
    private Map<Double, String> turtleInfo;


    private ListView<String> listView;
    private final String stringFormat = "Turtle ID: %s\n" + "x=%s, y=%s\n" + "visible=%s, penDown=%s";

    public TurtleStateBox (){
        this.setText("Turtle State List");
        this.setStyle("-fx-border-color: black;");
        this.setPrefSize(400,200);   
        this.listView = new ListView<String>();
        this.turtleInfo = new HashMap<Double, String>();
        this.setContent(listView);
    }

    public void updateTurtleStateBox(TurtleTransferObject turtleDTO){
        listView.setEditable(true);
        turtleInfo.put(turtleDTO.getID(), createTurtleInfoString(turtleDTO));
        turtleData = FXCollections.observableArrayList(new ArrayList<String>(turtleInfo.values()));
        listView.setItems(turtleData);
    }

    private String createTurtleInfoString(TurtleTransferObject turtleDTO){
        double x = -turtleDTO.getNextLoc()[0];
        double y = -turtleDTO.getNextLoc()[1];
        return String.format(stringFormat, turtleDTO.getID(), Math.abs(x)<0.5 ? 0:x, Math.abs(y)<0.5 ? 0:y, turtleDTO.isVisible(), turtleDTO.isPenDown());
    }
}
