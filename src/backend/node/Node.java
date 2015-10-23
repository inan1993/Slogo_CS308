package backend.node;

import java.util.ArrayList;
import java.util.List;

import responses.Response;

/**
 * @author loganrooper
 *
 */
public abstract class Node implements Cloneable {
	private String myName;
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

	public void setName(String name) {
		myName = name;
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
		return myName;
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

}
