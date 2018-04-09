package challange.taskOne;

import org.junit.Assert;
import org.junit.Test;

import challange.taskOne.interfaces.ActionChecker;
import challange.taskOne.interfaces.MessageChecker;
import challange.taskOne.mocks.ActionCheckerMock;
import challange.taskOne.mocks.MessageCheckerMock;

public class MessageTranslatorTest {

	@Test
	public void encryptMessage() {
		final String expected = "EBIIL";
		
		// constant, doesnt need to mock
		final Dictionary dictionary = new Dictionary();
		final MessageChecker messageChecker = new MessageCheckerMock();
		final ActionChecker actionChecker = new ActionCheckerMock();
		
		final MessageTranslator subject = new MessageTranslator(dictionary, messageChecker, actionChecker);
		
		final String translatedMessage = subject.translateMessage("encrypt", "HELLO");
		
		Assert.assertEquals(expected, translatedMessage);
	}
	
	@Test
	public void decryptMessage() {
		final String expected = "HELLO";
		
		// constant, doesnt need to mock
		final Dictionary dictionary = new Dictionary();
		final MessageChecker messageChecker = new MessageCheckerMock();
		final ActionChecker actionChecker = new ActionCheckerMock();
		
		final MessageTranslator subject = new MessageTranslator(dictionary, messageChecker, actionChecker);
		
		final String translatedMessage = subject.translateMessage("decrypt", "EBIIL");
		
		Assert.assertEquals(expected, translatedMessage);
	}	
	
	@Test
	public void encryptAlphabetMessage() {
		final String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		// constant, doesnt need to mock
		final Dictionary dictionary = new Dictionary();
		final MessageChecker messageChecker = new MessageCheckerMock();
		final ActionChecker actionChecker = new ActionCheckerMock();
		
		final MessageTranslator subject = new MessageTranslator(dictionary, messageChecker, actionChecker);
		
		final String translatedMessage = subject.translateMessage("encrypt", "DEFGHIJKLMNOPQRSTUVWXYZABC");
		
		Assert.assertEquals(expected, translatedMessage);
	}
	
	@Test
	public void decryptAlphabetMessage() {
		final String expected = "DEFGHIJKLMNOPQRSTUVWXYZABC";
		
		// constant, doesnt need to mock
		final Dictionary dictionary = new Dictionary();
		final MessageChecker messageChecker = new MessageCheckerMock();
		final ActionChecker actionChecker = new ActionCheckerMock();
		
		final MessageTranslator subject = new MessageTranslator(dictionary, messageChecker, actionChecker);
		
		final String translatedMessage = subject.translateMessage("decrypt", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		Assert.assertEquals(expected, translatedMessage);
	}
}
