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
public class Functions extends Observable {
	Map<String, Node> commandMap;
	Map<String, String> descriptionMap;

	public Functions() {
		commandMap = new HashMap<String, Node>();
		descriptionMap = new HashMap<String, String>();
		update();
	}
	
	private void update() {
		setChanged();
		notifyObservers("Function");
	}
	
	public void setCommand(String stringName, Node n) {
		setCommand("", stringName, n);
		update();
	}

	public void setCommand(String userInput, String stringName, Node n) {
		commandMap.put(stringName, n);
		descriptionMap.put(stringName, userInput);
		update();
	}

	public Node getCommand(String commandName) {
		return commandMap.get(commandName);
	}
	
	public Node getCommandDesription(String commandName) {
		return new Constant(0).setName(descriptionMap.get(commandName));
	}
	
	public List<String> getAllFunctionsAsString() {
		ArrayList<String> n = new ArrayList<String>();
		for (Map.Entry<String, Node> entry : commandMap.entrySet()) {
			String s = "";
			s += entry.getKey();
			s += " : ";
			s += descriptionMap.get(entry.getKey());
			n.add(s);
		}
		return n;
	}
}