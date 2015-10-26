package backend.node;

import java.util.ArrayList;
import java.util.List;

import responses.Response;
import sharedobjects.ManipulateController;

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
	
	public Response getAndRun(int index, ManipulateController mc) {
		return myChildren.get(index).run(mc);
	}
	
	public Node get(int index) {
		return myChildren.get(index);
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
	 * This is the main method that nodes call of each other.
	 * @param mc
	 * @return
	 */
	public abstract Response run(ManipulateController mc);
}
