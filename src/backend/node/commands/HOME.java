package backend.node.commands;

import backend.node.types.Command;
import responses.Response;
import responses.Success;
import sharedobjects.ITurtleLambda;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class HOME extends Command {

	public Response run(ManipulateController mc) {
		// get xy		
		ITurtleLambda l = (Turtle t) -> {
			t.setPosition(new double[]{0,0});
			t.notifyObservers("turtle");
		};
		mc.executeOnAllActiveTurtles(l);
		return new Success(0);
	}
}