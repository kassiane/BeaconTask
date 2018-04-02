package challange;

import java.util.HashMap;
import java.util.Map;

public class TaskOne {
	public static void main(String[] args) {
		final String action = args[0];
		final String message = args[1];
		
		final Map<Character, Character> encryptDictionary = createFromPlainToEncrypted();
		final Map<Character, Character> decryptDictionary = createFromEncryptedToPlain(encryptDictionary);
		
		if("decrypt".equalsIgnoreCase(action)) {
			System.out.println(encryptDecryptMessage(message, decryptDictionary));
		} else if("encrypt".equalsIgnoreCase(action)) {
			System.out.println(encryptDecryptMessage(message, encryptDictionary));
		} 
	}



	private static String encryptDecryptMessage(final String message, final Map<Character, Character> dictionary) {
		StringBuilder decryptedMessage = new StringBuilder();
		
		for(int characterPosition = 0; characterPosition < message.length(); characterPosition++) {
			decryptedMessage.append(dictionary.get(message.charAt(characterPosition)));
		}
		
		return decryptedMessage.toString();
	}
	
	public static Map<Character, Character> createFromPlainToEncrypted() {
		Map<Character, Character> fromPlainToEncrypted = new HashMap<Character, Character>();
		fromPlainToEncrypted.put('D', 'A');
		fromPlainToEncrypted.put('E', 'B');
		fromPlainToEncrypted.put('F', 'C');
		fromPlainToEncrypted.put('G', 'D');
		fromPlainToEncrypted.put('H', 'E');
		fromPlainToEncrypted.put('I', 'F');
		fromPlainToEncrypted.put('J', 'G');
		fromPlainToEncrypted.put('K', 'H');
		fromPlainToEncrypted.put('L', 'I');
		fromPlainToEncrypted.put('M', 'J');
		fromPlainToEncrypted.put('N', 'K');
		fromPlainToEncrypted.put('O', 'L');
		fromPlainToEncrypted.put('P', 'M');
		fromPlainToEncrypted.put('Q', 'N');
		fromPlainToEncrypted.put('R', 'O');
		fromPlainToEncrypted.put('S', 'P');
		fromPlainToEncrypted.put('T', 'Q');
		fromPlainToEncrypted.put('U', 'R');
		fromPlainToEncrypted.put('V', 'S');
		fromPlainToEncrypted.put('W', 'T');
		fromPlainToEncrypted.put('X', 'U');
		fromPlainToEncrypted.put('Y', 'V');
		fromPlainToEncrypted.put('Z', 'W');
		fromPlainToEncrypted.put('A', 'X');
		fromPlainToEncrypted.put('B', 'Y');
		fromPlainToEncrypted.put('C', 'Z');
		
		return fromPlainToEncrypted;
	}
	
	public static Map<Character, Character> createFromEncryptedToPlain(Map<Character, Character> fromPlainToEncrypted) {
		Map<Character, Character> fromEncryptedToPlain = new HashMap<Character, Character>();
		
		for (Map.Entry<Character, Character> entry: fromPlainToEncrypted.entrySet()) {
			fromEncryptedToPlain.put(entry.getValue(), entry.getKey());
		}
		
		return fromEncryptedToPlain;
	} 
}
