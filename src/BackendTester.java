import backend.*;
import backend.parser.*;

/**
 * @author loganrooper
 *
 */
public class BackendTester {
	public static void main(String[] args) {
		Parser p = new Parser();
		p.parse("fw 50");
	}
}
