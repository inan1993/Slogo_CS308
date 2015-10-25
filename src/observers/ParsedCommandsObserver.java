package observers;

import java.util.Observable;
import java.util.Observer;

import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import datatransferobjects.ParsedCommandsTransferObject;

public class ParsedCommandsObserver implements Observer{

    private FunctionListBox myFunctionList;
    private VariableListBox myVariableList;

    public ParsedCommandsObserver (FunctionListBox functionList, VariableListBox variableList) {
        this.myFunctionList = functionList;
        this.myVariableList = variableList;
    }

    @Override
    public void update (Observable o, Object arg) {
        ParsedCommandsTransferObject functionVariableDTO = (ParsedCommandsTransferObject) arg;
        System.out.println("variable observer");

        if(functionVariableDTO.isFunction()){
            myFunctionList.setMessage(functionVariableDTO.getUserInput()); 
        }
        else{
            myVariableList.setMessage(functionVariableDTO.getUserInput()); 

        }
    }
}
