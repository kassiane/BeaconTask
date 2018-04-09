package challange.taskOne;

import org.junit.Test;

import challange.taskOne.interfaces.ActionChecker;

public class ActionCheckerTest {

	@Test (expected = IllegalArgumentException.class)
	public void checkInvalidAction() {
		ActionChecker subject = new ActionCheckerImpl();
		
		subject.checkAction("blablabla");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkNullAction() {
		ActionChecker subject = new ActionCheckerImpl();
		
		subject.checkAction(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkEmptyAction() {
		ActionChecker subject = new ActionCheckerImpl();
		
		subject.checkAction("");
	}
	
	@Test
	public void checkAction() {
		ActionChecker subject = new ActionCheckerImpl();
		
		subject.checkAction("encrypt");
		subject.checkAction("decrypt");
	}
	
}
