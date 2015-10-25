package backend.node.control;

import responses.Response;
import backend.node.types.ControlStructure;
import responses.Error;
import sharedobjects.ManipulateController;

public class DOTIMES extends ControlStructure {
	@Override
	public Response run(ManipulateController mc) {
//		Double numExecutions = Double.parseDouble(exec.execute(nl.get(0)).toString());
//
//		// first node: [ var upperbound ]
//		Node var = nl.get(0);
//		Double upperBound = nl.get(1).getDoubleValue();
//		
//		Node listCommands = nl.get(2);
//		Response s = null;
//		// loop n times updating their counter variable
//		for (int i = 1; i < upperBound; i++) {
//			try {
//				exec.getManipulateController().setVariable(var.getName(), new Constant().setValue(i));
//				s = exec.execute(listCommands.clone());
//			} catch (CloneNotSupportedException e) {
//				throw new RuntimeException("Internal object manipulation error!");
//			}
//		}
//		if (s == null)
//			// No loops done
//			return new Constant().setValue(0.0);
//		// Return root return value
//		return new Constant().setValue(Double.parseDouble(s.toString()));
		return new Error("Unimplemented");
	}
}
