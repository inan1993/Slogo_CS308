/**
 * 
 */
package backend.node;

import java.util.List;

/**
 * @author loganrooper
 *
 */
public abstract class OneArgumentNode extends Node{
	public OneArgumentNode() {
		super();
		expectedArgumentNumber = 1;
	}
}