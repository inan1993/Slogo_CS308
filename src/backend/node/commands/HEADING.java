package backend.node.commands;

import backend.node.types.Command;
import backend.node.types.Constant;
import responses.Response;
import responses.Success;
import sharedobjects.Functions;
import sharedobjects.ManipulateController;
import sharedobjects.Turtle;

/**
 * @author loganrooper
 *
 */
public class HEADING extends Command{

	@Override
	public Response run(ManipulateController mc) {
		return new Success(mc.executeOnAllActiveTurtles((Turtle t) -> {return t.getHeading();}));
	}
}
