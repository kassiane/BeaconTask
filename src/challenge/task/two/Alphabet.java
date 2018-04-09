package challenge.task.two;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that has the map of alphabet character <-> number.
 *
 * @author kassi
 *
 */
public class Alphabet {

	public static final int ALPHABET_SIZE = 26;
	private final Map<String, Integer> alphabet;
	private final Map<Integer, String> numberToAlphabet;

	public Alphabet() {
		this.alphabet = new HashMap<String, Integer>();
		this.numberToAlphabet = new HashMap<Integer, String>();

		createAlphabetToNumber();
		createNumberToAlphabet(alphabet);
	}

	private void createAlphabetToNumber() {
		this.alphabet.put("A", 1);
		this.alphabet.put("B", 2);
		this.alphabet.put("C", 3);
		this.alphabet.put("D", 4);
		this.alphabet.put("E", 5);
		this.alphabet.put("F", 6);
		this.alphabet.put("G", 7);
		this.alphabet.put("H", 8);
		this.alphabet.put("I", 9);
		this.alphabet.put("J", 10);
		this.alphabet.put("K", 11);
		this.alphabet.put("L", 12);
		this.alphabet.put("M", 13);
		this.alphabet.put("N", 14);
		this.alphabet.put("O", 15);
		this.alphabet.put("P", 16);
		this.alphabet.put("Q", 17);
		this.alphabet.put("R", 18);
		this.alphabet.put("S", 19);
		this.alphabet.put("T", 20);
		this.alphabet.put("U", 21);
		this.alphabet.put("V", 22);
		this.alphabet.put("W", 23);
		this.alphabet.put("X", 24);
		this.alphabet.put("Y", 25);
		this.alphabet.put("Z", 26);
	}

	private void createNumberToAlphabet(final Map<String, Integer> alphabet) {
		for (final Map.Entry<String, Integer> entry : this.alphabet.entrySet()) {
			this.numberToAlphabet.put(entry.getValue(), entry.getKey());
		}
	}

	/**
	 * Method to return the map of an alphabet character to a number.
	 *
	 * @return the map containing alphabet character to number.
	 */
	public Map<String, Integer> getAlphabet() {
		return alphabet;
	}

	/**
	 * Method to return the map of a number to an alphabet character.
	 *
	 * @return the map containing number to alphabet character.
	 */
	public Map<Integer, String> getNumberToAlphabet() {
		return numberToAlphabet;
	}

	/**
	 * Method that returns the corresponding alphabet character from a number.
	 *
	 * @param numberAsChar
	 *            to be find.
	 * @return the alphabet character corresponding the number.
	 */
	public String getCharacterFromInteger(final char numberAsChar) {
		final String numberAsString = String.valueOf(numberAsChar);
		final Integer numberAsInteger = Integer.parseInt(numberAsString);

		return this.numberToAlphabet.get(numberAsInteger);
	}
}
