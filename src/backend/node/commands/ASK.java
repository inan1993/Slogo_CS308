package backend.node.commands;

import backend.node.types.ControlStructure;
import backend.node.types.TwoArgumentNode;
import responses.Response;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class ASK extends TwoArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call mc.setTempTurtles(array of ints)
		
		// Run everything in the list
		// Call mc.clearTempTurtles();
		return null;
	}
}