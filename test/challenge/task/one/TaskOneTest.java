package challenge.task.one;

import org.junit.Test;

/**
 * Class that tests {@link TaskOne}.
 *
 * @author kassi
 *
 */
public class TaskOneTest {

	@Test(expected = IllegalArgumentException.class)
	public void validateNullArguments() {
		final String[] args = null;

		TaskOne.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateZeroArguments() {
		final String[] args = new String[0];

		TaskOne.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateOneArgument() {
		final String[] args = new String[1];

		TaskOne.main(args);
	}

	@Test
	public void validateTwoArguments() {
		final String[] args = new String[] { "encrypt", "HELLO" };

		TaskOne.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThreeArguments() {
		final String[] args = new String[3];

		TaskOne.main(args);
	}
}
