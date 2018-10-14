/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */

public class IsUnique {
	public static void main(String args[]) {
		String[] tests = {"abcd", "abccd", "apple", "orange"};
		for(String words : tests) {
			if(isUnique(words))
				System.out.println("Unique");
			else
				System.out.println("Not Unique");
		}
	}
	
	//O(n^2)
	public static boolean isUnique(String input) {
		for(int i = 0; i < input.length()-1; i++) {
			char c = input.charAt(i);
			for(int j = i+1; j < input.length(); j++) {
				if(c == input.charAt(j))
					return false;
			}
		}
		return true;
	}

	//O(n) but uses a data structure
	public static boolean isUniqueDS(String input) {
		if(input.length() > 26) return false; //26 letters max
		int bit = 0;
		for(int i = 0; i < input.length(); i++) {
			int bitVal = input.charAt(i)-'a'; //a-a = 0, z-a = 26
			if((bit & (1 << bitVal)) > 0) //check if there is a 1 in bit at the digit of bitVal
				return false; //if there is then we've already seen this letter
			bit |= (1 << bitVal); //if there isn't then we use |= (OR operator) to add the 1 to bit at that index
		}
		return true;
	}
}
	
