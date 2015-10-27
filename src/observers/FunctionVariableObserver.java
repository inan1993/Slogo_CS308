package observers;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import sharedobjects.Functions;
import sharedobjects.Variables;

public class FunctionVariableObserver implements Observer{

    private FunctionListBox myFunctionList;
    private VariableListBox myVariableList;

    public FunctionVariableObserver (FunctionListBox functionList, VariableListBox variableList) {
        this.myFunctionList = functionList;
        this.myVariableList = variableList;
    }

    @Override
    public void update (Observable o, Object arg) {
        if(arg.equals("Function")){
        	List<String> s = ((Functions) o).getAllFunctionsAsString();
        	for (String a : s)
        		myFunctionList.setMessage(a); 
        }
        else {
        	//Variable
        	List<String> s = ((Variables) o).getAllVariables();
        	for (String a : s)
        		myVariableList.setMessage(a); 

        }
    }
}
