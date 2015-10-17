/**
 * 
 */
package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.node.Node;

/**
 * @author loganrooper
 *
 */
public class BK extends Node {
	public BK(String name, int children) {
		super(name, children);
	}

	/* (non-Javadoc)
	 * @see backend.node.Node#run(SharedObjects.WorkSpaceController, java.util.List)
	 */
	@Override
	protected Node run(WorkSpaceController sharedHandle, List<Node> returnedNodes) {
		// TODO Auto-generated method stub
		return null;
	}
}
