package challenge.task.two.interfaces;

/**
 * Interface for the Test Checker.
 *
 * @author kassi
 *
 */
public interface TextChecker {

	/**
	 * Checks if the text informed is valid, it should contain only numbers from 1
	 * to 9.
	 *
	 * @param textInNumber
	 *            to be checked.
	 */
	public void checkText(final String textInNumber);

}
