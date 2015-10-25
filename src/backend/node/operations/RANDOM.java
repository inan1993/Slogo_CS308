package backend.node.operations;

import java.util.Random;

import backend.node.TwoArgumentNode;
import responses.Response;
import responses.Success;
import sharedobjects.ManipulateController;

/**
 * @author loganrooper
 *
 */
public class RANDOM extends TwoArgumentNode{
	public RANDOM() {
		super();
	}

	@Override
	public Response run(ManipulateController mc) {
		Double max = getChild(0).getDoubleValue();
		Random rand = new Random();
		int i = rand.nextInt((int) Math.round(max));
		
		return new Success(i);
	}
}
