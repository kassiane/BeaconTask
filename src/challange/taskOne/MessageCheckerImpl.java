package challange.taskOne;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import challange.taskOne.interfaces.MessageChecker;

/**
 * Class that checks if the message specified is valid.
 * 
 * @author kassi
 *
 */
public class MessageCheckerImpl implements MessageChecker {

	public void checkMessage(final String message) {
		if(message == null) {
			throw new IllegalArgumentException("The message is nor formated correctly, please inform a message.");
		}
		
		final Pattern pattern = Pattern.compile("[a-zA-Z]+");
		final Matcher matcher = pattern.matcher(message);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("The message is nor formated correctly, it accepts only characters.");
		}
	}
}
