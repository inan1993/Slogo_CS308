/**
 * 
 */
package backend.node.commands;


import backend.node.types.Command;
import backend.node.types.ZeroArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class CS extends ZeroArgumentNode {

	@Override
	public Response run(ManipulateController sharedHandle) {
		sharedHandle.showTurtle();

		//First home
		Response s = sharedHandle.home();
		double distanceMoved = Double.parseDouble(s.toString());
		
		//Now clear
		sharedHandle.clearScreen();
		
		//Return the distance moved
		return new Success(distanceMoved);
	}
}