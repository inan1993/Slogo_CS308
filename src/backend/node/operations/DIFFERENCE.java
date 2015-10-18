/**
 * 
 */
package backend.node.operations;

import java.util.List;

import backend.node.Node;
import backend.node.Operation;

/**
 * @author loganrooper
 *
 */
public class DIFFERENCE extends Operation{
	public DIFFERENCE(String name, int num) {
		super(name, num);
	}

	@Override
	public Node run(List<Node> nl) {	
		return null;
	}
}
