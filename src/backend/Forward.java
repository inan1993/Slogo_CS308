package backend;

public class Forward extends Command {
	protected Forward(String name, int num) {
		super(name, num);
		// TODO Auto-generated constructor stub
	}

	static {
		NodeFactory factory = new NodeFactory();
		factory.registerNode("Forward",Forward.class);
	}
}
