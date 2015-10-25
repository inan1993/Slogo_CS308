package backend.node;

import java.util.ArrayList;
import java.util.List;

import responses.Response;

/**
 * @author loganrooper
 *
 */
public abstract class Node implements Cloneable {
	private String name;
	private List<Node> myChildren;
	private double myValue;

	public Node() {
		myChildren = new ArrayList<Node>();
	}

	public Node addChild(Node node) {
		myChildren.add(node);
		return node;
	}

	public Node addChildren(Node... nodes) {
		for (Node n : nodes)
			myChildren.add(n);

		return nodes[0];
	}
	
	private void clearChildren() {
		myChildren = new ArrayList<Node>();
	}
	
	public Node setChildren(Node...nodes) {
		clearChildren();
		addChildren(nodes);
		return nodes[0];
	}
	
	public int getChildrenNum() {
		return myChildren.size();
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean hasChildren() {
		return (myChildren.size() > 0);
	}

	public List<Node> getChildren() {
		return myChildren;
	}

	/**
	 * @return the myName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the myValue
	 */
	public double getDoubleValue() {
		return myValue;
	}

	/**
	 * @return
	 */
	public int getIntegerValue() {
		return (int) myValue;
	}

	/**
	 * @param myValue
	 *            the myValue to set
	 * @return
	 */
	public Node setValue(double myValue) {
		this.myValue = myValue;
		return this;
	}

	@Override
	public Node clone() throws CloneNotSupportedException {
		return (Node) super.clone();
	}

	/**
	 * 
	 */
	public void prepare() {
		// TODO Auto-generated method stub
		//if control, this will split 
	}

}
