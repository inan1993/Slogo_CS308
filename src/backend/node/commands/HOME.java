package backend.node.commands;

import backend.node.types.Command;
import datatransferobjects.TurtleTransferObject;
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
			TurtleTransferObject dto = new TurtleTransferObject(false, t.getID(), false, t.isPenDown(), t.getPosition(), new int[]{0,0});
			t.setPosition(new int[]{0,0});
			t.notifyObservers(dto);
		};
		mc.execute(l);
		return new Success(0);
	}
}