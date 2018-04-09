package challenge.task.one;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains the dictionary to encrypt or decrypt characters.
 *
 * @author kassi
 *
 */
public class Dictionary {

	private final Map<Character, Character> encryptDictionary;
	private final Map<Character, Character> decryptDictionary;

	public Dictionary() {
		this.encryptDictionary = new HashMap<Character, Character>();
		this.decryptDictionary = new HashMap<Character, Character>();

		this.createFromPlainToEncrypted();
		this.createFromEncryptedToPlain();
	}

	private void createFromPlainToEncrypted() {
		encryptDictionary.put('D', 'A');
		encryptDictionary.put('E', 'B');
		encryptDictionary.put('F', 'C');
		encryptDictionary.put('G', 'D');
		encryptDictionary.put('H', 'E');
		encryptDictionary.put('I', 'F');
		encryptDictionary.put('J', 'G');
		encryptDictionary.put('K', 'H');
		encryptDictionary.put('L', 'I');
		encryptDictionary.put('M', 'J');
		encryptDictionary.put('N', 'K');
		encryptDictionary.put('O', 'L');
		encryptDictionary.put('P', 'M');
		encryptDictionary.put('Q', 'N');
		encryptDictionary.put('R', 'O');
		encryptDictionary.put('S', 'P');
		encryptDictionary.put('T', 'Q');
		encryptDictionary.put('U', 'R');
		encryptDictionary.put('V', 'S');
		encryptDictionary.put('W', 'T');
		encryptDictionary.put('X', 'U');
		encryptDictionary.put('Y', 'V');
		encryptDictionary.put('Z', 'W');
		encryptDictionary.put('A', 'X');
		encryptDictionary.put('B', 'Y');
		encryptDictionary.put('C', 'Z');
	}

	private void createFromEncryptedToPlain() {
		for (final Map.Entry<Character, Character> entry : this.encryptDictionary.entrySet()) {
			this.decryptDictionary.put(entry.getValue(), entry.getKey());
		}
	}

	public Map<Character, Character> getEncryptDictionary() {
		return encryptDictionary;
	}

	public Map<Character, Character> getDecryptDictionary() {
		return decryptDictionary;
	}

}
