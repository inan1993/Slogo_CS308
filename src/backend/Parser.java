package backend;

import responses.*;

/**
 * @author loganrooper
 *
 */
public class Parser {
	Executor exec;
	
	public Parser() {
		//Call run to start.
		exec = new Executor();
	}
	
	public Response run(String[] input) {
		Response ret = null;
		for (String line : input) {
			ret = parse(line);
		}
		return ret;
	}
	
	private Response parse(String line) {
		Command root = new Command();
		return exec.execute(root);
	}
}
