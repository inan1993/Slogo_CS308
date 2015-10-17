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
	public abstract String toString();
}
