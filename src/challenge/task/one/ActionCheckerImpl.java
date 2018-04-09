package challenge.task.one;

import challenge.task.one.interfaces.ActionChecker;

/**
 * Class that checks if the action specified is valid.
 *
 * @author kassi
 *
 */
public class ActionCheckerImpl implements ActionChecker {

	@Override
	public void checkAction(final String action) {
		TranslateMode.fromString(action);
	}
}
