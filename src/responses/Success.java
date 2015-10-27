package responses;


/**
 * @author loganrooper
 *
 */
public class Success extends Response{

	public Success(String msg) {
		super(msg);
		this.setChanged();
	}
	
	public Success(Double d) {
		super(d);
		this.setChanged();
	}

	/**
	 * @param i
	 */
	public Success(int i) {
		super(i);
		this.setChanged();
	}
}
