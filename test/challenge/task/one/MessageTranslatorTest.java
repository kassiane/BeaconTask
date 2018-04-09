package challenge.task.one;

import org.junit.Assert;
import org.junit.Test;

import challenge.task.one.interfaces.ActionChecker;
import challenge.task.one.interfaces.MessageChecker;
import challenge.task.one.mocks.ActionCheckerMock;
import challenge.task.one.mocks.MessageCheckerMock;

/**
 * Class that tests {@link MessageTranslator}.
 *
 * @author kassi
 *
 */
public class MessageTranslatorTest {

	@Test
	public void encryptMessage() {
		final String expected = "EBIIL";

		// constant, doesn't need to mock
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

		// constant, doesn't need to mock
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

		// constant, doesn't need to mock
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

		// constant, doesn't need to mock
		final Dictionary dictionary = new Dictionary();
		final MessageChecker messageChecker = new MessageCheckerMock();
		final ActionChecker actionChecker = new ActionCheckerMock();

		final MessageTranslator subject = new MessageTranslator(dictionary, messageChecker, actionChecker);

		final String translatedMessage = subject.translateMessage("decrypt", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		Assert.assertEquals(expected, translatedMessage);
	}
}
