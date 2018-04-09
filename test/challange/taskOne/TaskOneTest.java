package challange.taskOne;

import org.junit.Test;

public class TaskOneTest {

	@Test (expected = IllegalArgumentException.class)
	public void validateNullArguments() {
		String[] args = null;
		
		TaskOne.main(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void validateZeroArguments() {
		String[] args = new String[0];	
		
		TaskOne.main(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void validateOneArgument() {
		String[] args = new String[1];
		
		TaskOne.main(args);
	}
	
	public void validateTwoArguments() {
		String[] args = new String[2];
		
		TaskOne.main(args);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void validateThreeArguments() {
		String[] args = new String[3];
		
		TaskOne.main(args);
	}
}
