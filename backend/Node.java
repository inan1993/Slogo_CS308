/**
 * 
 */
package backend;

import java.util.List;

/**
 * @author loganrooper
 *
 */
public abstract class Node {
	private String name;
	private List<Node> children;
	
	protected abstract Node run();
}
