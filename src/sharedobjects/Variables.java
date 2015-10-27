/**
 * 
 */
package sharedobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import backend.node.Node;
import backend.node.types.Constant;

/**
 * @author loganrooper
 *
 */
public class Variables extends Observable {
	Map<String, Node> variableMap;

	public Variables() {
		variableMap = new HashMap<String, Node>();
		update();
	}

	public void setVariable(String variableName, Node var) {
		addVariable(variableName, var);
		update();
	}

	private void update() {
		setChanged();
		notifyObservers("Variable");
	}

	public void addVariable(String v, Node n) {
		variableMap.put(v, n);
		update();
	}

	public Node getVariable(String variableName) {
		return variableMap.get(variableName);
	}

	public void incrementVariable(String var) {
		incrementVariableByValue(var, 1);
	}

	public void incrementVariableByValue(String variableName, int value) {
		double n = variableMap.get(variableName).getDoubleValue() + value;
		variableMap.put(variableName, new Constant(n));
		update();
	}

	public void decrementVariable(String variableName) {
		incrementVariableByValue(variableName, -1);
	}

	public List<String> getAllVariables() {
		ArrayList<String> n = new ArrayList<String>();
		for (Map.Entry<String, Node> entry : variableMap.entrySet()) {
			String s = "";
			s += entry.getKey();
			s += " : ";
			s += entry.getValue().getDoubleValue();
			n.add(s);
		}
		return n;
	}
}
