package challange.taskOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that checks if the message specified is valid.
 * 
 * @author kassi
 *
 */
public class MessageChecker {

	public void checkMessage(final String message) {
		Pattern patter = Pattern.compile("[a-zA-z]*");
		Matcher matcher = patter.matcher(message);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("The message is nor formated correctly, it accepts only characters.");
		}
	}
}
