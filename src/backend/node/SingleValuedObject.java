/**
 * 
 */
package backend.node;

import java.util.List;

import SharedObjects.WorkSpaceController;

/**
 * @author loganrooper
 *
 */
public abstract class SingleValuedObject extends Node{
	
	/**
	 * @param name
	 * @param num
	 */
	public SingleValuedObject(String name, int num) {
		super(name, 0);
	}
}
