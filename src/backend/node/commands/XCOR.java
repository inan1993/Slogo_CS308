package backend.node.commands;

import backend.node.types.Command;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class XCOR extends Command{

	@Override
	public Response run(ManipulateController mc) {
		//return new Success(mc.get);
		return new Success(1);
	}

}
