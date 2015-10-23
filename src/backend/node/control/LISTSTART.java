package backend.node.control;

import java.util.List;

import backend.node.Constant;
import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;
import responses.Response;


public class LISTSTART extends ControlStructure {
	public LISTSTART(){
		super();
	}

	@Override
	protected Node run(List<Node> nl, Executor executor) {
		// Just run each node and return the last value
		Response s = null;
		for (Node n : nl) {
			s = executor.execute(n);
		}
		if (s == null)
			this.setValue(0.0);
		this.setValue(Double.parseDouble(s.toString()));
		return this;
	}
}
