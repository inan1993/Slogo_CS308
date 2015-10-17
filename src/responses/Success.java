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

	@Override
	public String toString() {
		return message;
	}

}
