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
		myName = name;
		myNumOfChildren = num;
	}

	protected abstract Node run();

	public void addChild(Node node) {
		myChildren.add(node);
	}

	public int getChildrenNum() {
		return myNumOfChildren;
	}
	
	public void setName(String name){
		myName=name;
	}

	public Boolean hasChildren() {
		return (getChildrenNum() > 0);
	}
	
	public List<Node> getChildren() {
		return myChildren;
	}
}
