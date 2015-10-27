/**
 * 
 */
package sharedobjects;

import backend.node.Node;

@FunctionalInterface
public interface IWorkspaceVariablesLambda{
 //the abstract method	
 public Node run(Variables vars);
}