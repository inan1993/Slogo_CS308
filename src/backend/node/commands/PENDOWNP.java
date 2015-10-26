package backend.node.commands;

import backend.node.types.Command;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class PENDOWNP extends Command{

	@Override
	public Response run(ManipulateController mc) {
		// TODO Auto-generated method stub
		return new Success(0);
	}

}
