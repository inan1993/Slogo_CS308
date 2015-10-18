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
public class RANDOM extends Operation{
	public RANDOM() {
		super();
	}

	@Override
	public Node run(List<Node> nl) {	
		Double max = nl.get(0).getDoubleValue();
		Random rand = new Random();
		int i = rand.nextInt((int) Math.round(max));
		
		return new Constant().setValue((double) i);
	}
}
