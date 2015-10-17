package backend.node;

import java.util.List;

import SharedObjects.WorkSpaceController;

public class Constant extends Node {
	
	public Constant(String s) {
		super(s, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Node run(WorkSpaceController sharedHandle, List<Node> returnedNodes) {
		// Nothing to do.
		return this;
	}
	
	

}
