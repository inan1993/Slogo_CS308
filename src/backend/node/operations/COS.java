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
public class COS extends Operation{
	public COS() {
		super();
	}

	@Override
	public Node run(List<Node> nl) {	
		Double x = nl.get(0).getDoubleValue();
		//convert input to radians, cos, conver to degrees
		return new Constant().setValue(Math.toDegrees(Math.cos(Math.toRadians(x))));
	}
}