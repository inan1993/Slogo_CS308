/**
 * 
 */
package sharedobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import backend.node.Node;
import backend.node.types.Constant;

/**
 * @author loganrooper
 *
 */
public class Variables extends Observable{
	Map<String, Node> variableMap;
	
	public Variables() {
		variableMap = new HashMap<String, Node>();
		this.setChanged();
	}
	
	public void setVariable(String variableName, Node var) {
		addVariable(variableName, var);
		this.setChanged();
	}
	
	public void addVariable(String v, Node n) {
		variableMap.put(v, n);
		this.setChanged();
	}

	public Node getVariable(String variableName) {
		return variableMap.get(variableName);
	}

	public void incrementVariable(String var) {
		incrementVariableByValue(var, 1);
	}

	public void incrementVariableByValue(String variableName, int value) {
		double n = variableMap.get(variableName).getDoubleValue()+value;
		variableMap.put(variableName, new Constant(n));
		this.setChanged();
	}

	public void decrementVariable(String variableName) {
		incrementVariableByValue(variableName, -1);
	}
}
