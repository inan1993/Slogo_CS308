package GUI.viewbox;

public class FunctionListBox extends AViewBox {

    public FunctionListBox (){//String text) {
        super();//text);
        this.setText("Function List");
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
