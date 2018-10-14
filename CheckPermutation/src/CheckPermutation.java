/*
 * Given two strings, write a method to decide if one is a permutation of the other
 */

public class CheckPermutation {
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for(String[] pair : pairs) {
		String a = pair[0];
		String b = pair[1];
		boolean perm = checkPermutation(a,b);
		System.out.println(a + " and " + b +" : " + perm);
		}
	}
	
	//O(n)
	public static boolean checkPermutation(String one, String two) {
		if(one.length() != two.length()) //both strings need to be same length to be permutations of each other
			return false;
		int bitOne = 0;
		int bitTwo = 0;
		
		//iterate through both strings letter by letter and add to bit vector
		for(int i = 0; i < one.length(); i++) {
			int bitValOne = one.charAt(i) - 'a'; //get bit index for strings
			int bitValTwo = two.charAt(i) - 'a'; //a-a = 0, z-a = 26
			
			//if we come across a repetition of a letter, set its bit vector index to 0.
			//Both strings have to have the same # of each letter
			//to be permutations of each other so we can do that
			if((bitOne & (1 << bitValOne)) > 0) {
				bitOne ^= (1 << bitValOne); //set index to 0 by doing 1 XOR 1
			}
			else 
				bitOne |= (1 << bitValOne); //add new index to bit vector
			
			if((bitTwo & (1 << bitValTwo)) > 0) {
				bitTwo ^= (1 << bitValTwo);
			}
			else
				bitTwo |= (1 << bitValTwo);
		}
		if(bitOne == bitTwo)
			return true;
		else
			return false;
	}
}
