package challenge.task.one;

/**
 * Enumeration that represents the possible translate actions.
 *
 * @author kassi
 *
 */
public enum TranslateMode {
	ENCRYPT, DECRYPT;

	/**
	 * Receives a string and returns its corresponding Enumeration.
	 *
	 * @param action
	 *            to be Enumerated.
	 *
	 * @return the Enumeration that corresponds the action.
	 */
	public static TranslateMode fromString(final String action) {
		if (action == null || action.isEmpty()) {
			throw new IllegalArgumentException("Action should not be null or empty.");
		}
		return Enum.valueOf(TranslateMode.class, action.toUpperCase().trim());
	}
}
