package challenge.task.two;

import java.util.Stack;

/**
 * Description In this task we'll try to solve a another algorithmic challenge.
 *
 * Given a direct mapping between the characters of the alphabet and the numbers
 * from 1 to 26
 *
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 10 11
 * 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
 *
 * we try to find all the possible character strings for a given number. For
 * instance, the number 123 can be encoded as "ABC" (1, 2, 3), "LC" (12, 3) or
 * "AW" (1, 23)
 *
 * Task Write a small command line program to find all possible strings that
 * match a given number with arbitrary length. This program takes the number as
 * parameter.
 *
 * Example user@maya:~$ ./find_strings 123 ABC LC AW Requirements You can use
 * whatever language you like. Create a GitHub repository to document your work
 * flow. Add basic error handling (users provide a wrong parameter for instance)
 *
 * @author kassi
 *
 */
public class TaskTwo {

	public static void main(final String[] args) {
		final Alphabet alphabet = new Alphabet();
		final TextCheckerImpl textChecker = new TextCheckerImpl();
		final StringFinder stringFinder = new StringFinder(alphabet, textChecker);

		// check the number of parameters
		if (args == null || args.length != 1) {
			throw new IllegalArgumentException(
			        "Invalid number of arguments to find the possible character strings, inform a text consisted by numbers.");
		}

		// get the text in numbers from arguments
		final String textInNumber = args[0];

		final Stack<String> possibleStrings = stringFinder.findStrings(textInNumber);

		while (!possibleStrings.isEmpty()) {
			System.out.println(possibleStrings.pop());
		}

	}

}