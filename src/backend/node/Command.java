/**
 * 
 */
package backend.node;

import java.util.List;

import responses.Response;
import sharedobjects.ManipulateController;


/**
 * @author loganrooper
 *
 */
public abstract class Command extends Node{
	
	public Command() {
		super();
	}
	
	/**
	 * A command requires two arguments
	 * @param wsc
	 * @param returnedNodes
	 * @return
	 */
	protected abstract Node run(ManipulateController wsc, List<Node> returnedNodes);
}
