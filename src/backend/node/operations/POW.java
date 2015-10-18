/**
 * 
 */
package backend.node.operations;

import java.util.List;

import backend.node.Constant;
import backend.node.Node;
import backend.node.Operation;

/**
 * @author loganrooper
 *
 */
public class POW extends Operation{
	public POW() {
		super();
	}

	@Override
	public Node run(List<Node> nl) {	
		Double result = Math.pow(nl.get(0).getDoubleValue(), nl.get(1).getDoubleValue());
		return new Constant().setValue(result);
	}
}