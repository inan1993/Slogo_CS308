package sharedobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import backend.node.Node;

public class UserInputs extends Observable {
	
	Map<String, Node> commandMap;
	Map<String, Node> variableMap;
	
	public UserInputs() {
		commandMap = new HashMap<String, Node>();
		variableMap = new HashMap<String, Node>();
	}
	
	public void addVariable(String v, Node n){
		variableMap.put(v, n);
	}
	
	public Node getVariable(String v){
		return variableMap.get(v);
	}
	
	public void addCommand(String c, Node n){
		commandMap.put(c, n);
	}
	
	public Node getCommand(String c){
		return commandMap.get(c);
	}

}
