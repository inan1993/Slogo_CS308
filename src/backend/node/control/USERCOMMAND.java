package backend.node.control;


import backend.node.types.ControlStructure;
import responses.Error;
import responses.Response;
import sharedobjects.ManipulateController;

public class USERCOMMAND extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		return new Error("Unimplemented");
	}
}
