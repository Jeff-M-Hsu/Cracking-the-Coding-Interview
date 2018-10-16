/*
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 */
public class PalindromePermutation {
	public static void main(String[] args) {
		String[] words = {"Tact Coa", "Zeus was deified, saw Suez", "Rats live on no evil star", "rrceaac", "abcdef"};
		for(String w : words) {
			if(paliPermV(w.toLowerCase()))
				System.out.println(w + ": True");
			else
				System.out.println(w + ":False");
		}
	}

	//O(n) performs operations on char array of size n and
	//then searches through int array of constant size to find answer
	public static boolean paliPerm(String word) {
		int[] numTable = new int[26];
		for(char c : word.toCharArray()) {
			int x = c - 'a';
			if(x < 0 || x > 26) {} //check if x corresponds to a letter
			else
				numTable[x]++;
		}
		boolean foundOdd = false;
		for(int i = 0; i < numTable.length; i++) {
			if(numTable[i] % 2 == 1) {
				if(foundOdd)
					return false;
				foundOdd = true;
			}
		}

		return true;
	}

	//O(n) solution that takes far less space than than the above solution,
	//using only one int instead of an array of 26 ints
	public static boolean paliPermV(String word) {
		int vector = 0;
		for(int i = 0; i < word.length(); i++) {
			int bit = word.charAt(i) - 'a'; 
			if(bit < 0 || bit > 26) {} //check if bit corresponds to a letter
			else {
				if((vector & (1<<bit)) > 0) //if we've already seen the letter before use XOR to reset to 0,
					vector ^= 1<<bit;		//we don't care about even occurances of letters
				else
					vector |= 1<<bit;		//if the letter is new then OR it to vector to add it
			}
		}
		if((vector & (vector-1)) == 0 || vector == 0)		//if vector==0 then there are even number of each letter in the word, hence palindrome
			return true;								 	//if there is one '1' in the bit vector then there is only one letter with an odd # of occurances
		else return false;									//which we determine by ANDing the vector and vector-1 and checking if it equals 0
	}														//ex. 1000-1=0111, 1000 AND 0111 = 0000 = 0
}
