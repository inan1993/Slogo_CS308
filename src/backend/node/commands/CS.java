/**
 * 
 */
package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import responses.Response;

/**
 * @author loganrooper
 *
 */
public class CS extends Command {
	public CS(String name, int children) {
		super(name, children);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		sharedHandle.showTurtle();

		//First home
		Response s = sharedHandle.home();
		double distanceMoved = Double.parseDouble(s.toString());
		
		//Now clear
		sharedHandle.clearScreen();
		
		//Return the distance moved
		return new Constant("Moved").setValue(distanceMoved);
	}
}