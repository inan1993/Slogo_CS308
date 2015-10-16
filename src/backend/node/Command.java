/**
 * 
 */
package backend.node;

import responses.Response;

/**
 * @author loganrooper
 *
 */
public abstract class Command extends Node{
	
	protected Command(String name, int num) {
		super(name, num);
	}

	@Override
	protected abstract Response run();
	
}
