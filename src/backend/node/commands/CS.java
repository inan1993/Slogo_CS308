/**
 * 
 */
package backend.node.commands;

import java.util.List;

import backend.node.Command;
import backend.node.Constant;
import backend.node.Node;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class CS extends Command {
	public CS(String name, int children) {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		sharedHandle.showTurtle();

		//First home
		Response s = sharedHandle.home();
		double distanceMoved = Double.parseDouble(s.toString());
		
		//Now clear
		sharedHandle.clearScreen();
		
		//Return the distance moved
		return new Constant().setValue(distanceMoved);
	}

}