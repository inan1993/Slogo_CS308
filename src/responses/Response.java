/**
 * 
 */
package responses;

/**
 * @author loganrooper
 *
 */
public abstract class Response {
	
	protected String message;
	public Response(String msg)	{
		message=msg;
	}
	public Response(Double d) {
		message = d.toString();
	}
	/**
	 * @param i
	 */
	public Response(int i) {
		message = Integer.toString(i);
	}
	public String toString() {
		return this.message;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(message);
	}
	
	public int getIntegerValue() {
		return (int) Double.parseDouble(message);
	}
}
