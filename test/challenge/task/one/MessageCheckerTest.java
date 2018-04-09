package challenge.task.one;

import org.junit.Test;

import challenge.task.one.interfaces.MessageChecker;

/**
 * Class that tests {@link MessageChecker}.
 *
 * @author kassi
 *
 */
public class MessageCheckerTest {

	@Test(expected = IllegalArgumentException.class)
	public void translateMessageWithNullMessage() {
		final MessageChecker subject = new MessageCheckerImpl();

		subject.checkMessage(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void translateMessageWithEmptyMessage() {
		final MessageChecker subject = new MessageCheckerImpl();

		subject.checkMessage("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void translateMessageWithNumbers() {
		final MessageChecker subject = new MessageCheckerImpl();

		subject.checkMessage("ab12");
	}

	@Test
	public void translateValidMessage() {
		final MessageChecker subject = new MessageCheckerImpl();

		subject.checkMessage("abcdefg");
	}

}
