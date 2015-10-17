/**
 * 
 */
package backend.node;

import java.util.List;

import SharedObjects.WorkSpaceController;
import responses.Response;

/**
 * @author loganrooper
 *
 */
public abstract class Command extends Node{
	
	protected Command(String name, int num) {
		super();
		super.setChildrenNum(num);
		super.setName(name);
	}
	
	/**
	 * A command requires two arguments
	 * @param wsc
	 * @param returnedNodes
	 * @return
	 */
	protected abstract Node run(WorkSpaceController wsc, List<Node> returnedNodes);
}
