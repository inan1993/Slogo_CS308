package datatransferobjects;

public class UserInputTransferObject {

    String language;
    String userInput;
    public UserInputTransferObject (String lang, String input) {
        this.language = lang;
        this.userInput = input;
    }
    public String getLanguage () {
        return language;
    }
    
    public String getUserInput () {
        return userInput;
    }
    
}

//package datatransferobjects;
//
//public class ParsedCommandsTransferObject {
//        
//        private boolean function;
//        private String userInput;
//        
//        public ParsedCommandsTransferObject(boolean f, String u) {
//                function = f;
//                userInput = u;
//        }
//
//        public boolean isFunction() {
//                return function;
//        }
//
//        public String getUserInput() {
//                return userInput;
//        }
//}
