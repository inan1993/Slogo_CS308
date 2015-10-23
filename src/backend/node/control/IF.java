package backend.node.control;

import java.util.List;

import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;

public class IF extends ControlStructure {
	public IF(){
		super();
		super.setChildrenNum(2);
	}

	@Override
	protected Node run(List<Node> nl, Executor executor) {
		// TODO Auto-generated method stub
		//test
		return null;
	}
}
