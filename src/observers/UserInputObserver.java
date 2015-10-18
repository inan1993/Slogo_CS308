package observers;

import java.util.Observable;
import java.util.Observer;

import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import datatransferobjects.UserInputsTransferObject;

public class UserInputObserver implements Observer{

	private FunctionListBox myFunctionList;
    private VariableListBox myVariableList;

	public UserInputObserver (FunctionListBox functionList, VariableListBox variableList) {
		this.myFunctionList = functionList;
		this.myVariableList = variableList;
	}

	@Override
	public void update (Observable o, Object arg) {
		UserInputsTransferObject functionVariableDTO = (UserInputsTransferObject) arg;


		if(functionVariableDTO.isFunction()){
			myFunctionList.setMessage(functionVariableDTO.getUserInput()); 
		}
		else{
			myVariableList.setMessage(functionVariableDTO.getUserInput()); 
          
		}
	}
}

// 