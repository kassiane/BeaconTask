package challenge.task.two;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import challenge.task.two.interfaces.TextChecker;
import challenge.taskTwo.mocks.TextCheckerMock;

/**
 * Class that tests {@link StringFinder}.
 *
 * @author kassi
 *
 */
public class StringFinderTest {

	@Test
	public void findStringsWhenConcatenatingFourAlgarisms() {
		final String text = "7268";
		final Set<String> expected = new HashSet<String>();
		expected.add("GBFH");
		expected.add("GZH");

		final StringFinder subject = setupSubject();

		final Stack<String> result = subject.findStrings(text);

		assertResult(expected, result);
	}

	@Test
	public void findStringsWhenConcatenatingThreeAlgarisms() {
		final String text = "123";
		final Set<String> expected = new HashSet<String>();
		expected.add("ABC");
		expected.add("LC");
		expected.add("AW");

		final StringFinder subject = setupSubject();

		final Stack<String> result = subject.findStrings(text);

		assertResult(expected, result);
	}

	@Test
	public void findStringsWhenConcatenatingOneAlgarism() {
		final String text = "7";
		final Set<String> expected = new HashSet<String>();
		expected.add("G");

		final StringFinder subject = setupSubject();

		final Stack<String> result = subject.findStrings(text);

		assertResult(expected, result);
	}

	private StringFinder setupSubject() {
		// this is a constant doesnt need to be mock
		final Alphabet alphabet = new Alphabet();
		final TextChecker textChecker = new TextCheckerMock();
		final StringFinder subject = new StringFinder(alphabet, textChecker);
		return subject;
	}

	private void assertResult(final Set<String> expected, final Stack<String> result) {
		Assert.assertEquals(expected.size(), result.size());

		for (final String string : result) {
			Assert.assertTrue(expected.contains(string));
		}
	}
}
