package observers;

import java.util.Observable;
import java.util.Observer;

import GUI.turtlepane.TurtleCanvas;
import GUI.turtlepane.TurtleGroup;
import GUI.viewbox.FunctionListBox;
import GUI.viewbox.VariableListBox;
import datatransferobjects.TurtleTransferObject;

public class UserInputObserver implements Observer{

	private FunctionListBox myFunctionList;
    private VariableListBox myVariableList;

	public UserInputObserver (FunctionListBox functionList, VariableListBox variableList) {
		this.myFunctionList = functionList;
		this.myVariableList = variableList;
	}

	@Override
	public void update (Observable o, Object arg) {
		//SomeTransferObject functionVariableDTO = (SomeTransferObject) arg;


//		if(functionVariableDTO.isFunction()){
//			myFunctionList.setMessage(functionVariableDTO.passedString()); 
//		}
//		else{
//			myVariableList.setMessage(functionVariableDTO.passedString()); 
//          
//		}
	}
}

// 