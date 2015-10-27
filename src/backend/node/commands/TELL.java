/**
 * 
 */
package backend.node.commands;

import java.util.LinkedList;
import java.util.List;

import backend.node.types.OneArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class TELL extends OneArgumentNode {
	@Override
	public Response run(ManipulateController mc) {
		// Call setTurtleIDS(array of ints) -> this should create turtles as well
		// If only one argument then I'll create a range 0->x
		int numChildren = getChildren().get(0).getChildrenNum();
		int[] ids = new int[numChildren];
		for(int i =0; i < numChildren; i++){
			ids[i] = getAndRun(i, mc).getIntegerValue();
		}
		
		int id = mc.tellTurtles(ids);
		return new Success(id);
	}
}