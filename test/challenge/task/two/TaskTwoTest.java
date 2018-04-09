package challenge.task.two;

import org.junit.Test;

/**
 * Class that tests {@link TaskTwo}.
 *
 * @author kassi
 *
 */
public class TaskTwoTest {

	@Test(expected = IllegalArgumentException.class)
	public void validateNullArguments() {
		final String[] args = null;

		TaskTwo.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateZeroArguments() {
		final String[] args = new String[0];

		TaskTwo.main(args);
	}

	@Test
	public void validateOneArgument() {
		final String[] args = new String[] { "123" };

		TaskTwo.main(args);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateTwoArguments() {
		final String[] args = new String[2];

		TaskTwo.main(args);
	}

}
