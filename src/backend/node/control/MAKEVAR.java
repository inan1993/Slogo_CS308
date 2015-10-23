package backend.node.control;

import java.util.List;

import backend.node.Constant;
import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;

public class MAKEVAR extends ControlStructure {
	public MAKEVAR(){
		super();
	}

	@Override
	protected Node run(List<Node> nl, Executor executor) {
		Node var = nl.get(0);
		Node result = new Constant().setValue(Double.parseDouble(executor.execute(nl.get(1)).toString()));
		executor.getManipulateController().setVariable(var.getName(), result);
		return result;
	}
}