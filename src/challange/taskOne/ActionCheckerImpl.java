package challange.taskOne;

import challange.taskOne.interfaces.ActionChecker;

/**
 * Class that checks if the action specified is valid.
 * 
 * @author kassi
 *
 */
public class ActionCheckerImpl implements ActionChecker {
	
	public void checkAction(final String action) {
		TranslateMode.fromString(action);
	}
	
}
