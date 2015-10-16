package backend.node;

import backend.factory.NodeFactory;

public class Forward extends Command {
	protected Forward() {
		super("Forward", 1);
		// TODO Auto-generated constructor stub
	}

	static {
		NodeFactory factory = new NodeFactory();
		factory.registerNode("Forward",Forward.class);
	}
}
