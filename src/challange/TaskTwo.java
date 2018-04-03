package challange;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TaskTwo {

	public static void main(String[] args) {
		String textInNumber = "123";
		
		Map<String, Integer> alphabet = new HashMap<String, Integer>();
		alphabet.put("A", 1);
		alphabet.put("B", 2);
		alphabet.put("C", 3);
		alphabet.put("D", 4);
		alphabet.put("E", 5);
		alphabet.put("F", 6);
		alphabet.put("G", 7);
		alphabet.put("H", 8);
		alphabet.put("I", 9);
		alphabet.put("J", 10);
		alphabet.put("K", 11);
		alphabet.put("L", 12);
		alphabet.put("M", 13);
		alphabet.put("N", 14);
		alphabet.put("O", 15);
		alphabet.put("P", 16);
		alphabet.put("Q", 17);
		alphabet.put("R", 18);
		alphabet.put("S", 19);
		alphabet.put("T", 20);
		alphabet.put("U", 21);
		alphabet.put("V", 22);
		alphabet.put("W", 23);
		alphabet.put("X", 24);
		alphabet.put("Y", 25);
		alphabet.put("Z", 26);
		
		Map<Integer, String> numberToAlphabet = new HashMap<Integer, String>();
		numberToAlphabet.put(1, "A");
		numberToAlphabet.put(2, "B");
		numberToAlphabet.put(3, "C");
		numberToAlphabet.put(4, "D");
		numberToAlphabet.put(5, "E");
		numberToAlphabet.put(6, "F");
		numberToAlphabet.put(7, "G");
		numberToAlphabet.put(8, "H");
		numberToAlphabet.put(9, "I");
		numberToAlphabet.put(10, "J");
		numberToAlphabet.put(11, "K");
		numberToAlphabet.put(12, "L");
		numberToAlphabet.put(13, "M");
		numberToAlphabet.put(14, "N");
		numberToAlphabet.put(15, "O");
		numberToAlphabet.put(16, "P");
		numberToAlphabet.put(17, "Q");
		numberToAlphabet.put(18, "R");
		numberToAlphabet.put(19, "S");
		numberToAlphabet.put(20, "T");
		numberToAlphabet.put(21, "U");
		numberToAlphabet.put(22, "V");
		numberToAlphabet.put(23, "W");
		numberToAlphabet.put(24, "X");
		numberToAlphabet.put(25, "Y");
		numberToAlphabet.put(26, "Z");
		
		
		Stack<String> something = new Stack<>();
		
		
		
		String firstChar = String.valueOf(textInNumber.charAt(0));
		Integer firstCharInt = Integer.parseInt(firstChar);
		String firstString = numberToAlphabet.get(firstCharInt);
		
		something.push(firstString);
		
		for(int characterPosition = 1; characterPosition < textInNumber.length(); characterPosition++) {
			String characterAtPosition = String.valueOf(textInNumber.charAt(characterPosition));
			Stack<String> newStrings = new Stack<>();
			
			while(!something.isEmpty()) {
				// get the last string in the stack
				String lastString = something.pop(); 
				
				// first part, just add the character in the end
				String newString = lastString + String.valueOf(numberToAlphabet.get(Integer.parseInt(characterAtPosition)));
				// push in other stack
				newStrings.push(newString);
				
				// now get the last character of the string
				String lastCharacter = String.valueOf(lastString.charAt(lastString.length() - 1));
				Integer valueOfLastCharacter = alphabet.get(String.valueOf(lastCharacter));
				
				// and check if the concatenation between both values is a letter
				String newCharValue = String.valueOf(valueOfLastCharacter) + characterAtPosition;
				if(Integer.parseInt(newCharValue) <= 26) {
					String newChar = numberToAlphabet.get(Integer.parseInt(newCharValue));
					// remove the last char of the string and append the new char
					newString = lastString.substring(0, lastString.length() - 1);
					newString = newString + newChar;
					
					//put it in the stack
					newStrings.push(newString);
				}
			}

			// in the end of all, clone the other stack to something stack
			something.addAll(newStrings);
		}
		
		
		
		while(!something.isEmpty()) {
			System.out.println(something.pop());
		}
		
	}
	
}