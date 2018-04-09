package challenge.task.two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import challenge.task.two.interfaces.TextChecker;

/**
 * Class that checks if the text specified is valid.
 *
 * @author kassi
 *
 */
public class TextCheckerImpl implements TextChecker {

	@Override
	public void checkText(final String textInNumber) {
		if (textInNumber == null) {
			throw new IllegalArgumentException("The text is not formated correctly, please inform a text.");
		}

		final Pattern patter = Pattern.compile("[1-9]+");
		final Matcher matcher = patter.matcher(textInNumber);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(
			        "The text is not formated correctly, it accepts only numbers from 1 to 9.");
		}
	}
}
