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
public class Functions extends Observable {
	Map<String, Node> commandMap;
	Map<String, String> descriptionMap;

	public Functions() {
		commandMap = new HashMap<String, Node>();
		descriptionMap = new HashMap<String, String>();
		
		this.setChanged();
	}
	
	public void setCommand(String stringName, Node n) {
		setCommand("", stringName, n);
		this.setChanged();
	}

	public void setCommand(String userInput, String stringName, Node n) {
		commandMap.put(stringName, n);
		descriptionMap.put(stringName, userInput);
		this.setChanged();
	}

	public Node getCommand(String commandName) {
		return commandMap.get(commandName);
	}
	
	public Node getCommandDesription(String commandName) {
		return new Constant(0).setName(descriptionMap.get(commandName));
	}
}