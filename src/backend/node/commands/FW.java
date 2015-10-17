package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import backend.factory.NodeFactory;
import backend.node.Command;
import backend.node.Node;
import responses.Response;

public class FW extends Command {
	protected FW(String s) {
		super(s, 1);
		// TODO Auto-generated constructor stub
	}

	static {
		CommandFactory factory = new CommandFactory();
		factory.registerNode(SyntaxType.FORWARD, Forward.class);
	}

	@Override
	protected Node run(WorkSpaceController sharedHandle, List<Node> ln) {
	     //move forward using argument 1 pixels
		 sharedHandle.foward(ln.get(0).getValue());
		 //return argument 1 value
		 return ln.get(0);
	}
}
