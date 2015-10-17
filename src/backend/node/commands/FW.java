package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import backend.node.Command;
import backend.node.Node;

public class FW extends Command {
	public FW(String s) {
		super(s, 1);
		// TODO Auto-generated constructor stub
	}

	static {
		CommandFactory factory = new CommandFactory();
		factory.registerNode(SyntaxType.FORWARD, Forward.class);
	}

	@Override
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		sharedHandle.foward(ln.get(0).getIntegerValue());
		
		// return argument 1 value
		return ln.get(0);
	}
}
