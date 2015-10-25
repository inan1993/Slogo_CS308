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

	@Override
	public String toString() {
		return message;
	}

	@Override
	public double toDouble() {
		return Double.parseDouble(message);
	}

}
