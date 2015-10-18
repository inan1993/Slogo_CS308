package sharedobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class HandleObservers {

	//map of Observable (String name) to their Observers (List<String name>)
    private static final Map<String, List<String>> observableMap = new HashMap<String,List<String>>() {{
        put("Turtle", new LinkedList<String>(Arrays.asList("Observer1","Observer2")));
    }};
    
	public HandleObservers() {}
	
	public void handleObservers(List<Observable> observablesOList, List<Observer> observersOList){
    	for(Observable observableO: observablesOList){
    		String observableName = observableO.getClass().getName();
    		List<String> observersSList = observableMap.get(observableName);
    		if(observersSList != null){
    			for(Observer observerO: observersOList){
    				String observerName = observerO.getClass().getName();	
    				if(observersSList.contains(observerName)){
    					linkObserverableObserver(observableO, observerO);
    				}
    			}
    		}
    	}
    }
	
	private void linkObserverableObserver(Observable observableO, Observer observerO) {
		//Perform Observer/Observable Linking
		observableO.addObserver(observerO);
		
	}

}
