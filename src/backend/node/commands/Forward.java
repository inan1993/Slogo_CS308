package backend.node.commands;

import java.util.List;

import backend.factory.CommandFactory;
import backend.node.Command;
import backend.node.Node;
import backend.parser.SyntaxType;
import sharedobjects.ManipulateController;

public class Forward extends Command {
	protected Forward(String s) {
		super();
		// TODO Auto-generated constructor stub
	}

	static {
		CommandFactory factory = new CommandFactory();
		factory.registerNode(SyntaxType.FORWARD, Forward.class);
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		// move forward using argument 1
		sharedHandle.foward(ln.get(0).getIntegerValue());
		
		// return argument 1 value
		return ln.get(0);
	}
}
