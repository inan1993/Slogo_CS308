/**
 * 
 */
package responses;

/**
 * @author loganrooper
 *
 */
public class Success extends Response{

	public Success(String msg) {
		super(msg);
	}
	
	public Success(Double d) {
		super(d);
	}

	/**
	 * @param i
	 */
	public Success(int i) {
		super(i);
	}
}
