/**
 * 
 */
package backend.node.types;

import backend.node.Node;

/**
 * @author loganrooper
 *
 */
public abstract class ZeroArgumentNode extends Node{
	public ZeroArgumentNode() {
		super();
		expectedArgumentNumber = 0;
	}
}