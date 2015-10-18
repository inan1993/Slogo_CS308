/**
 * 
 */
package backend.node;

import java.util.List;

/**
 * @author loganrooper
 *
 */
public abstract class Operation extends Node{
	public Operation() {
		super();
	}
	
	public abstract Node run(List<Node> list);
}