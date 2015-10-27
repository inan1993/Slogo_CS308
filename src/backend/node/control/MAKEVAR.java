package backend.node.control;

import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Response;
import sharedobjects.ManipulateController;

public class MAKEVAR extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		String variableName = get(0).getName();
		Double result = getAndRun(1, mc).getDoubleValue();
		return mc.setVariable(variableName, new Constant(result));
	}
}