package challenge.task.one;

import org.junit.Test;

import challenge.task.one.interfaces.ActionChecker;

/**
 * Class that tests {@link ActionChecker}.
 *
 * @author kassi
 *
 */
public class ActionCheckerTest {

	@Test(expected = IllegalArgumentException.class)
	public void checkInvalidAction() {
		final ActionChecker subject = new ActionCheckerImpl();

		subject.checkAction("blablabla");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkNullAction() {
		final ActionChecker subject = new ActionCheckerImpl();

		subject.checkAction(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkEmptyAction() {
		final ActionChecker subject = new ActionCheckerImpl();

		subject.checkAction("");
	}

	@Test
	public void checkAction() {
		final ActionChecker subject = new ActionCheckerImpl();

		subject.checkAction("encrypt");
		subject.checkAction("decrypt");
	}

}
