package datatransferobjects;

public class UserInputsTransferObject {
	
	private boolean function;
	private String userInput;
	
	public UserInputsTransferObject(boolean f, String u) {
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
