package backend.node;

import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import responses.Response;

public class Forward extends Command {
	protected Forward(String s) {
		super(s, 1);
		// TODO Auto-generated constructor stub
	}

	static {
		CommandFactory factory = new CommandFactory();
		factory.registerNode(SyntaxType.FORWARD, Forward.class);
	}

	@Override
	protected Node run() {
		// TODO Auto-generated method stub
		return null;
	}
}
