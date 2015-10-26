/**
 * 
 */
package responses;

import java.util.Observable;

/**
 * @author loganrooper
 *
 */
public abstract class Response extends Observable{
	
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
	
	/**
	 * This is used for state transfer between classes.
	 */
	public void updateValue(String s) {
		message = s;
		this.setChanged();
	}
}
