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
public class MINUS extends Operation{
	public MINUS() {
		super();
	}

	@Override
	public Node run(List<Node> nl) {	
		Double result = nl.get(0).getDoubleValue()*-1;
		return new Constant().setValue(result);
	}
}
