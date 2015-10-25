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
	public abstract String toString();
	public abstract double toDouble();
}
