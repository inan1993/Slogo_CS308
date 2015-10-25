package backend.node.control;


import backend.node.ControlStructure;
import responses.Error;
import responses.Response;
import sharedobjects.ManipulateController;

public class REPEAT extends ControlStructure {
	public REPEAT() {
		super();
	}

//	@Override
//	protected Node run(List<Node> nl, Executor exec) {
//		Double numExecutions = Double.parseDouble(exec.execute(nl.get(0)).toString()); 
//		
//		//Use second node...
//		Node n = nl.get(1);
//		Response s = null;
//		//...to loop n times
//		for (int i = 0; i < numExecutions-1; i++) {
//			try {
//				s = exec.execute(n.clone());
//			} catch (CloneNotSupportedException e) {
//				throw new RuntimeException("Internal object manipulation error!");
//			}
//		}
//		if (s == null)
//			//No loops done
//			return new Constant().setValue(0.0); 
//		//Return root return value
//		return new Constant().setValue(Double.parseDouble(s.toString()));
//	}
	@Override
	public Response run(ManipulateController mc) {
		return new Error("Unimplemented");
	}
}
