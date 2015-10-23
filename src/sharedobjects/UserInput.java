package sharedobjects;

import java.util.Observable;

public class UserInput extends Observable{

    String userInput;
    String currentLanguage;
    
    public UserInput (String defaultLang) {
        this.currentLanguage = defaultLang;
    }
    
    public String getUserInput () {
        return userInput;
    }
    
    public void setUserInput (String userInput) {
        this.userInput = userInput;
        this.setChanged();
    }

    public String getCurrentLanguage () {
        return currentLanguage;
    }

    public void setCurrentLanguage (String currentLanguage) {
        this.currentLanguage = currentLanguage;
        this.setChanged();
    }

}
