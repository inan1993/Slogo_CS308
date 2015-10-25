package backend.node.control;


import backend.node.ControlStructure;
import responses.Error;
import responses.Response;
import sharedobjects.ManipulateController;

public class IFELSE extends ControlStructure {
	public IFELSE(){
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		return new Error("Unimplemented");
	}
}
