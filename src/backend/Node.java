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
	private String myName;
	private List<Node> myChildren;
	private int myNumOfChildren;
	
	protected Node(String name, int num) {
		myName=name;
		myNumOfChildren=num;
	}
	
	protected abstract Node run();
	
	protected void addChildren(Node node) {
		myChildren.add(node);
	}
	
	protected int getChildrenNum(){
		return myNumOfChildren;
	}
}
