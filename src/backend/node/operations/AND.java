/**
 * 
 */
package backend.node.operations;

import java.util.List;
import java.util.Random;

import backend.node.Constant;
import backend.node.Node;
import backend.node.Operation;

/**
 * @author loganrooper
 *
 */
public class AND extends Operation{
	public AND() {
		super();
	}

	@Override
	public Node run(List<Node> nl) {	
		Double a = nl.get(0).getDoubleValue();
		Double b = nl.get(1).getDoubleValue();
		//convert input to radians, cos, conver to degrees
		return new Constant().setValue(a > 0 && b > 0 ? 1 : 0);
	}
}