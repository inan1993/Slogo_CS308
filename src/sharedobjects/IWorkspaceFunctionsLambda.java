package sharedobjects;

import backend.node.Node;

@FunctionalInterface
public interface IWorkspaceFunctionsLambda{
 //the abstract method	
 public Node run(Functions funcs);
}