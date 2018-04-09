package challenge.task.two;

import java.util.Map;
import java.util.Stack;

import challenge.task.two.interfaces.TextChecker;

/**
 * Class that finds strings that can be formed from a string of numbers.
 *
 * @author kassi
 *
 */
public class StringFinder {

	private final Alphabet alphabet;
	private final TextChecker textChecker;

	public StringFinder(final Alphabet alphabet, final TextChecker textChecker) {
		this.alphabet = alphabet;
		this.textChecker = textChecker;
	}

	/**
	 * Finds all strings that match the text in numbers informed.
	 *
	 * @param textInNumber
	 *            to be used as basis to find the strings.
	 * @return all strings matching the text in numbers informed.
	 */
	public Stack<String> findStrings(final String textInNumber) {
		// check if it is valid
		textChecker.checkText(textInNumber);

		final Stack<String> possibleStrings = new Stack<String>();

		final String firstCharFromInteger = alphabet.getCharacterFromInteger(textInNumber.charAt(0));
		possibleStrings.push(firstCharFromInteger);

		for (int characterPosition = 1; characterPosition < textInNumber.length(); characterPosition++) {
			final Stack<String> newStrings = new Stack<>();

			while (!possibleStrings.isEmpty()) {
				// get the last string in the stack
				final String lastString = possibleStrings.pop();

				final char number = textInNumber.charAt(characterPosition);
				final String numberAsString = String.valueOf(number);

				// first part, just add the character in the end
				String newString = addCharacterToTheEnd(lastString, number);
				// push in other stack
				newStrings.push(newString);

				// now get the last character of the string
				final Integer valueOfLastCharacter = getValueOfLastCharacterFromString(alphabet.getAlphabet(),
				        lastString);

				// and check if the concatenation between both values is a letter
				final String newCharValue = valueOfLastCharacter + numberAsString;
				if (Integer.parseInt(newCharValue) <= Alphabet.ALPHABET_SIZE) {
					newString = replaceLastChar(lastString, newCharValue);
					// put it in the stack
					newStrings.push(newString);
				}
			}

			// in the end of all, clone the other stack to something stack
			possibleStrings.addAll(newStrings);
		}

		return possibleStrings;

	}

	private String replaceLastChar(final String lastString, final String newCharValue) {
		final Map<Integer, String> numberToAlphabet = alphabet.getNumberToAlphabet();
		final String newChar = numberToAlphabet.get(Integer.parseInt(newCharValue));

		// remove the last char of the string and append the new char
		final String newString = lastString.substring(0, lastString.length() - 1);

		return newString + newChar;
	}

	private Integer getValueOfLastCharacterFromString(final Map<String, Integer> alphabet, final String lastString) {
		final String lastCharacter = String.valueOf(lastString.charAt(lastString.length() - 1));
		final Integer valueOfLastCharacter = alphabet.get(String.valueOf(lastCharacter));
		return valueOfLastCharacter;
	}

	private String addCharacterToTheEnd(final String lastString, final char number) {
		final String charFromInteger = alphabet.getCharacterFromInteger(number);
		final String newString = lastString + charFromInteger;

		return newString;
	}
}
