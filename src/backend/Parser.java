/**
 * 
 */
package backend;

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
	
	public String run(String[] input) {
		String result = "";
		for (String line : input) {
			result = parse(line);
		}
		return result;
	}
	
	private String parse(String line) {
		Command root = new Command();
		exec.execute(root);
		
		return "";
	}
}
