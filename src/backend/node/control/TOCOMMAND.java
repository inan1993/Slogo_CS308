package backend.node.control;


import backend.node.types.ControlStructure;
import responses.Error;
import responses.Response;
import sharedobjects.ManipulateController;

public class TOCOMMAND extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		return new Error("Unimplemented");
	}
}
