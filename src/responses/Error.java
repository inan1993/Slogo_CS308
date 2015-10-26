/**
 * 
 */
package responses;

import backend.parser.SyntaxException;

/**
 * @author loganrooper
 *
 */
public class Error extends Response {

	public Error(String msg) {
		super(msg);
		throw new SyntaxException(msg.toString());
	}
}