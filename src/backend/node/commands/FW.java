/**
 * 
 */
package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.node.Node;
import responses.Response;
import responses.Success;

/**
 * @author loganrooper
 *
 */
public class FW extends Node{
	public FW(String name, int children) {
		super(name, children);
	}

	/* (non-Javadoc)
	 * @see backend.node.Node#run(SharedObjects.WorkSpaceController)
	 */
	@Override
	protected Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		 //If no children but FW, it's wrong!
		 if (ln == null)
			 throw new RuntimeException("Missing parameter.");
	     //move forward using argument 1
		 sharedHandle.foward(ln.get(0).getValue());
		 //return argument 1 value
		 return ln.get(0);
	}
}
