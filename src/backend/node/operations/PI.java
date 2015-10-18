/**
 * 
 */
package backend.node.operations;

import java.util.List;

import backend.node.Constant;
import backend.node.Node;
import backend.node.Operation;
import backend.node.SingleValuedObject;

/**
 * @author loganrooper
 *
 */
public class PI extends SingleValuedObject {
	public PI() {
		super();
		this.setValue(Math.PI);
	}
}