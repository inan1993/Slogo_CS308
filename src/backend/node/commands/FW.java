package backend.node.commands;

import java.util.List;

import SharedObjects.WorkSpaceController;
import backend.factory.CommandFactory;
import backend.parser.SyntaxType;
import backend.node.Command;
import backend.node.Node;

public class FW extends Command {
	public FW()
	{
		super(null,1);
	}
	
	public FW(String s) {
		super(s, 1);
		// TODO Auto-generated constructor stub
	}

	static {
		CommandFactory factory = new CommandFactory();
		factory.registerCmd(SyntaxType.FORWARD, FW.class);
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
