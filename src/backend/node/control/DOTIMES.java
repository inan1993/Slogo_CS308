package backend.node.control;

import java.util.List;

import backend.node.Constant;
import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;
import responses.Response;
import sharedobjects.ManipulateController;

public class DOTIMES extends ControlStructure {

	public DOTIMES() {
		super();
		super.setChildrenNum(3);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Node run(List<Node> nl, Executor exec) {
		Double numExecutions = Double.parseDouble(exec.execute(nl.get(0)).toString());

		// first node: [ var upperbound ]
		Node var = nl.get(0);
		Double upperBound = nl.get(1).getDoubleValue();
		
		Node listCommands = nl.get(2);
		Response s = null;
		// loop n times updating their counter variable
		for (int i = 1; i < upperBound; i++) {
			try {
				exec.getManipulateController().setVariable(var.getName(), new Constant().setValue(i));
				s = exec.execute(listCommands.clone());
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException("Internal object manipulation error!");
			}
		}
		if (s == null)
			// No loops done
			return new Constant().setValue(0.0);
		// Return root return value
		return new Constant().setValue(Double.parseDouble(s.toString()));
	}

}
