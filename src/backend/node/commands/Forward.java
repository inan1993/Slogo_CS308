package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import backend.factory.NodeFactory;
import backend.node.Command;
import backend.node.Node;
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
	public Node run(WorkSpaceController sharedHandle, List<Node> ln) {
		 //If no children but FW, it's wrong!
		 if (ln == null)
			 throw new RuntimeException("Missing parameter.");
	     //move forward using argument 1
		 sharedHandle.foward(ln.get(0).getIntegerValue());
		 //return argument 1 value
		 return ln.get(0);
	}
}
