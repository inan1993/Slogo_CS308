package backend.node.control;

import java.util.List;

import backend.node.Constant;
import backend.node.ControlStructure;
import backend.node.Executor;
import backend.node.Node;
import responses.Response;

public class Repeat extends ControlStructure {
	public Repeat() {
		super();
		super.setChildrenNum(2);
	}

	@Override
	protected Node run(List<Node> nl, Executor exec) {
		Double numExecutions = Double.parseDouble(exec.execute(nl.get(0)).toString()); 
		
		//Use second node...
		Node n = nl.get(1);
		Response s = null;
		//...to loop n times
		for (int i = 0; i < numExecutions-1; i++) {
			try {
				s = exec.execute(n.clone());
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException("Internal object manipulation error");
			}
		}
		if (s == null)
			//No loops done
			return new Constant().setValue(0.0); 
		//Return root return value
		return new Constant().setValue(Double.parseDouble(s.toString()));
	}
}
