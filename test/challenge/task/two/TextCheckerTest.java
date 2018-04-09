package challenge.task.two;

import org.junit.Test;

import challenge.task.two.TextCheckerImpl;
import challenge.task.two.interfaces.TextChecker;

/**
 * Class that tests {@link TextCheckerImpl}.
 * 
 * @author kassi
 *
 */
public class TextCheckerTest {

	@Test(expected = IllegalArgumentException.class)
	public void checkTextNull() {
		final TextChecker subject = new TextCheckerImpl();

		subject.checkText(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkTextEmpty() {
		final TextChecker subject = new TextCheckerImpl();

		subject.checkText("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkTextWithCharacters() {
		final TextChecker subject = new TextCheckerImpl();

		subject.checkText("4536abc123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkTextWithZero() {
		final TextChecker subject = new TextCheckerImpl();

		subject.checkText("12309801");
	}

	@Test
	public void checkValidText() {
		final TextChecker subject = new TextCheckerImpl();

		subject.checkText("123456789");
	}
}
