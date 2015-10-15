/**
 * 
 */
package responses;

/**
 * @author loganrooper
 *
 */
public abstract class Response {
	
	private String message;
	public Response(String msg)	{
		message=msg;
	}
	public abstract String toString();
}
