/**
 * 
 */
package backend.node;

import java.util.List;

import SharedObjects.WorkSpaceController;
import responses.Response;

/**
 * @author loganrooper
 *
 */
public abstract class Node {
	private String myName;
	private List<Node> myChildren;
	private int myNumOfChildren;
	private double myValue;

	public Node(String name, int num) {
		myName = name;
		myNumOfChildren = num;
	}


	protected abstract Node run(WorkSpaceController sharedHandle, List<Node> returnedNodes);

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

	/**
	 * @return the myName
	 */
	public String getName() {
		return myName;
	}

	/**
	 * @return the myValue
	 */
	public double getValue() {
		return myValue;
	}

	/**
	 * @param myValue the myValue to set
	 */
	public void setValue(double myValue) {
		this.myValue = myValue;
	}
}
