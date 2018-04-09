package challenge.task.one;

import java.util.Map;

import challenge.task.one.interfaces.ActionChecker;
import challenge.task.one.interfaces.MessageChecker;

/**
 * Class that translates a message into another one, encrypting or decrypting
 * characters according to the action chosen.
 *
 * @author kassi
 *
 */
public class MessageTranslator {

	private final Dictionary dictionary;
	private final MessageChecker messageChecker;
	private final ActionChecker actionChecker;

	public MessageTranslator(final Dictionary dictionary, final MessageChecker messageChecker,
	        final ActionChecker actionChecker) {
		this.dictionary = dictionary;
		this.messageChecker = messageChecker;
		this.actionChecker = actionChecker;

	}

	/**
	 * Translates a message, encrypting or decrypting characters.
	 *
	 * @param action
	 *            that should be applied to the message.
	 * @param message
	 *            that should be translated.
	 *
	 * @return the translated message.
	 */
	public String translateMessage(final String action, final String message) {
		String translatedMessage = "";

		// check if it is a valid message
		messageChecker.checkMessage(message);

		// check if it is a valid action
		actionChecker.checkAction(action);

		switch (TranslateMode.fromString(action)) {
		case DECRYPT:
			translatedMessage = encryptDecryptMessage(message.toUpperCase(), dictionary.getDecryptDictionary());
			break;
		case ENCRYPT:
			translatedMessage = encryptDecryptMessage(message.toUpperCase(), dictionary.getEncryptDictionary());
			break;
		default:
			throw new IllegalArgumentException("This action is not supported.");
		}
		return translatedMessage;
	}

	private String encryptDecryptMessage(final String message, final Map<Character, Character> dictionary) {
		final StringBuilder encryptedDecryptedMessage = new StringBuilder();

		for (int characterPosition = 0; characterPosition < message.length(); characterPosition++) {
			encryptedDecryptedMessage.append(dictionary.get(message.charAt(characterPosition)));
		}

		return encryptedDecryptedMessage.toString();
	}

}
