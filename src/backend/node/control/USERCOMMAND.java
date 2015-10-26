package backend.node.control;


import backend.node.Node;
import backend.node.types.Constant;
import backend.node.types.ControlStructure;
import responses.Response;
import sharedobjects.ManipulateController;

public class USERCOMMAND extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
		Node root = mc.getCommand(getName());
		//Set variables to parameters
		for (int i = 0; i < getChildrenNum(); i++) {
			String var = root.get(i).getName();
			mc.setVariable(var, new Constant(get(0).getDoubleValue()));
		}
		
		//Run the list
		return root.getAndRun(1, mc);
	}
}
