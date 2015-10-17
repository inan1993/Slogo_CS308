package backend.node;

import java.util.ArrayList;
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

	
	public Node(){
		myChildren=new ArrayList<Node>();
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
	
	public void setChildrenNum(int n){
		myNumOfChildren=n;
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
	 */
	public void setValue(double myValue) {
		this.myValue = myValue;
	}


	protected Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		// TODO Auto-generated method stub
		return null;
	}
}
