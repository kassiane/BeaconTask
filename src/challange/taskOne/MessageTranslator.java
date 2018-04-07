package challange.taskOne;

import java.util.Map;

/**
 * Class that translates a message into another one, encrypting or decrypting characters according to the action chosen.
 * 
 * @author kassi
 *
 */
public class MessageTranslator {

	private final Dictionary dictionary;
	
	public MessageTranslator(final Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	/**
	 * Translates a message, encrypting or decrypting characters.
	 * 
	 * @param action that should be applied to the message.
	 * @param message that should be translated.
	 * 
	 * @return the translated message.
	 */
	public String translateMessage(final String action,final String message) {
		String translatedMessage = "";
		
		switch(TranslateMode.fromString(action)) {
			case DECRYPT: 
				translatedMessage =  encryptDecryptMessage(message.toUpperCase(), dictionary.getDecryptDictionary());
				break;
			case ENCRYPT: 
				translatedMessage =  encryptDecryptMessage(message.toUpperCase(), dictionary.getEncryptDictionary());
				break;
			default: 
				throw new IllegalArgumentException("This action is not supported.");
		} 
		return translatedMessage;
	}


	private String encryptDecryptMessage(final String message, final Map<Character, Character> dictionary) {
		final StringBuilder encryptedDecryptedMessage = new StringBuilder();
		
		for(int characterPosition = 0; characterPosition < message.length(); characterPosition++) {
			encryptedDecryptedMessage.append(dictionary.get(message.charAt(characterPosition)));
		}
		
		return encryptedDecryptedMessage.toString();
	}

}
