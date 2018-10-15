/*
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 */
public class PalindromePermutation {
	public static void main(String[] args) {
		String[] words = {"Tact Coa", "tot to", "toto", "rrceaac", "abcdef"};
		for(String w : words) {
			if(paliPerm(w))
				System.out.println(w + ": True");
			else
				System.out.println(w + ":False");
		}
	}
	
	//O(n) performs operations on char array of size n and
	//then searches through int array of constant size to find answer
	public static boolean paliPerm(String word) {
		String lower = word.toLowerCase();
		lower = lower.replaceAll(" ", "");
		int[] numTable = new int[26];
		for(char c : lower.toCharArray()) {
			int x = c - 'a';
			numTable[x]++;
		}
		boolean foundOdd = false;
		if(lower.length() % 2 == 0) {
			for(int i = 0; i < numTable.length; i++) {
				if(numTable[i] % 2 == 1)
					if(foundOdd)
						return false;
					foundOdd = true;
			}
		}
		return true;
	}
}
