package challange.taskOne;

import org.junit.Test;

import challange.taskOne.interfaces.MessageChecker;

public class MessageCheckerTest {

	@Test (expected = IllegalArgumentException.class)
	public void translateMessageWithNullMessage() {
		MessageChecker subject = new MessageCheckerImpl();
		
		subject.checkMessage(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void translateMessageWithEmptyMessage() {
		MessageChecker subject = new MessageCheckerImpl();
		
		subject.checkMessage("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void translateMessageWithNumbers() {
		MessageChecker subject = new MessageCheckerImpl();
		
		subject.checkMessage("ab12");
	}
	
	@Test 
	public void translateValidMessage() {
		MessageChecker subject = new MessageCheckerImpl();
		
		subject.checkMessage("abcdefg");
	}
	
}
