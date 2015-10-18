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
	public Operation(String name, int num) {
		super(name, num);
	}
	
	public abstract Node run(List<Node> list);
}