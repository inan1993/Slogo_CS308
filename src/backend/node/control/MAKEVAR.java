package backend.node.control;

import java.util.List;

import backend.node.Node;
import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Error;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

public class MAKEVAR extends ControlStructure {

//	@Override
//	public Response run(ManipulateController mc) {
//		Node var = getChild(0);
//		Node result = new Constant().setValue(Double.parseDouble(executor.execute(nl.get(1)).toString()));
//		mc.setVariable(var.getName(), result);
//		return new Success(getChild(1).getDoubleValue());
//	}
	@Override
	public Response run(ManipulateController mc) {
		return new Error("Unimplemented");
	}
}