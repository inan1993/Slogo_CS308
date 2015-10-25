/**
 * 
 */
package responses;

/**
 * @author loganrooper
 *
 */
public class Error extends Response {

	public Error(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see responses.Response#toString()
	 */
	@Override
	public String toString() {
		return this.message;
	}
	
	@Override
	public double toDouble() {
		return Double.parseDouble(message);
	}
}
