package GUI.viewbox;

public class VariableListBox extends AViewBox {

    public VariableListBox (){//String text){
        super();//text);
        this.setText("Variables List");

    }

    @Override
    void setSize () {
        listView.setPrefSize(400, 200);
    }

    @Override
    void setStyle () {
        listView.setStyle("-fx-border-color: black;");
    }

}
