/**
 * 
 */
package backend.node;

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