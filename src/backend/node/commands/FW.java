/**
 * 
 */
package backend.node.commands;

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
	 * @see backend.node.Node#run()
	 */
	@Override
	protected Response run() {
		// TODO Auto-generated method stub
		return new Success("Did nothing! :)");
	}
}
