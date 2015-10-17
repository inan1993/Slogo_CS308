package GUI.viewbox;

public class CommandHistoryBox extends AViewBox {

    public CommandHistoryBox (){//String text) {
        super();//text);
        //this.setText(text);
        this.setText("Command History List");

    }

    @Override
    void setStyle () {
        listView.setStyle("-fx-border-color: black;");        
    }

    @Override
    void setSize () {
        listView.setPrefSize(400, 200);        
    }

}
