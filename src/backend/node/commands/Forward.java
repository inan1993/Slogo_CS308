package backend.node.commands;

import backend.factory.NodeFactory;
import backend.node.Command;
import backend.node.Node;
import responses.Response;

public class Forward extends Command {
	protected Forward(String name, int num) {
		super(name, num);
		// TODO Auto-generated constructor stub
	}

	static {
		NodeFactory factory = new NodeFactory();
		factory.registerNode("Forward",Forward.class);
	}

	/* (non-Javadoc)
	 * @see backend.node.Command#run()
	 */
	@Override
	protected Node run() {
		// TODO Auto-generated method stub
		return null;
	}
}
