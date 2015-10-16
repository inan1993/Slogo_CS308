/**
 * 
 */
package backend.node;

import java.util.List;

/**
 * @author loganrooper
 *
 */
public abstract class Node {
	private String myName;
	private List<Node> myChildren;
	private int myNumOfChildren;
	
	
	public Node(String name, int num) {
		myName=name;
		myNumOfChildren=num;
	}
	
	protected abstract Node run();
	
	public void addChildren(Node node) {
		myChildren.add(node);
	}
	
	public int getChildrenNum(){
		return myNumOfChildren;
	}
}
