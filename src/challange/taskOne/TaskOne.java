package challange.taskOne;

/**
 * TASK 1: Caesar Cipher
 * Description
 * One of the most popular cryptographic functions is called the "Caesar Cipher". Around 2000 years ago Caesar used this cipher to encrypt messages he sent to his troops without revealing the information to his enemies.
 * 
 * The basic idea of this cipher is to replace every single character in the message with another letter in the alphabet. The schema for replacing these characters is simply shifting by four. For instance D->A, C->Z.
 * 
 * Plain:     DEFGHIJKLMNOPQRSTUVWXYZABC
 * Encrypted: ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * The plain message HELLO will be encrypted to EBIIL
 * 
 * The encrypted message can be decrypted by simply back-shifting every single letter by four.
 * 
 * Task
 * Write a small program for the command line that implements the Caesar cipher. The program takes two parameters.
 * 
 * decrypt or encrypt. This parameter is used distinguish between the two modes of operation.
 * a message to be encrypted or decrypted.
 * Examples
 * user@maya:~$ ./caesar encrypt "HELLO"
 * EBIIL
 * 
 * user@maya:~$ ./caesar decrypt "EBIIL"
 * HELLO
 * 
 * @author kassi
 *
 */
public class TaskOne {
	public static void main(String[] args) {
		final String action = args[0];
		final String message = args[1];
		
		// check the number of parameters
		if(args.length != 2) {
			throw new IllegalArgumentException("Invalid number of arguments to translate a message, inform an action and a message.");
		}
		
		// check if it is a valid message
		final MessageChecker messageChecker = new MessageChecker();
		messageChecker.checkMessage(message);
		
		// check if it is a valid action
		final ActionChecker actionChecker = new ActionChecker();
		actionChecker.checkAction(action);
		
		final Dictionary dictionary = new Dictionary();
		final MessageTranslator messageTranslator = new MessageTranslator(dictionary);
		
		// translates the message
		final String translatedMessage = messageTranslator.translateMessage(action, message);
		
		System.out.println(translatedMessage);
	}
}
