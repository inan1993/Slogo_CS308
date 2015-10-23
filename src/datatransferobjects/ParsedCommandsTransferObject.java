package datatransferobjects;

public class ParsedCommandsTransferObject {
	
	private boolean function;
	private String userInput;
	
	public ParsedCommandsTransferObject(boolean f, String u) {
		function = f;
		userInput = u;
	}

	public boolean isFunction() {
		return function;
	}

	public String getUserInput() {
		return userInput;
	}
}
