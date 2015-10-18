package backend.node;

import java.util.ArrayList;
import java.util.List;

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
		myChildren = new ArrayList<Node>();
	}
	
	public Node addChild(Node node) {
		myChildren.add(node);
		myNumOfChildren = myChildren.size();
		return node;
	}

	public int getChildrenNum() {
		return myNumOfChildren;
	}
	
	public Node setName(String name){
		myName=name;
		return this;
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
	 * @param myValue the myValue to set
	 * @return 
	 */
	public Node setValue(double myValue) {
		this.myValue = myValue;
		return this;
	}
}
