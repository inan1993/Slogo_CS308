package backend.node.commands;

import java.util.List;
import backend.node.Command;
import backend.node.Node;
import sharedobjects.ManipulateController;

public class FD extends Command {
	public FD() {
		super();
	}

	@Override
	public Node run(ManipulateController sharedHandle, List<Node> ln) {
		if (ln == null)
			throw new RuntimeException("Missing parameter.");
		if (ln.size() < 1)
			throw new RuntimeException(String.format("Expected 1 parameter, got: %d", ln.size()));

		sharedHandle.foward(ln.get(0).getIntegerValue());
		return ln.get(0);
	}
}
