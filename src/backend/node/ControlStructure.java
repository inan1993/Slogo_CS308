/**
 * 
 */
package backend.node;

/**
 * @author loganrooper
 *
 */
public abstract class ControlStructure extends Node{

	protected ControlStructure(String name, int num) {
		super();
		super.setName(name);
		super.setChildrenNum(num);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see backend.Node#run()
	 */
	@Override
	protected Node run() {
		// TODO Auto-generated method stub
		return null;
	}

}
