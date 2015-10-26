package backend.node.control;


import backend.node.types.ControlStructure;
import responses.Response;
import responses.Error;
import responses.Success;
import sharedobjects.ManipulateController;

public class TOCOMMAND extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		//Check if command was defined in parser or not
		if (mc.getCommand(getName()) != null)
			return new Success(1);
		return new Error("Command not defined");
	}
}