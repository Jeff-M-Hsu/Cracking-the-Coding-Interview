/*
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit
 * (or zero edits) away.
 */

public class OneAway {
	public static void main(String[] args) {
		String[][] wordPairs = {{"pale", "ple"}, {"pales","pale"}, {"pale","bale"}, {"pale","bake"}};
		for(String[] pair : wordPairs){
			String first = pair[0];
			String second = pair[1];
			if(checkEdit(first, second))
				System.out.println(first + ", " + second + " : True");
			else
				System.out.println(first + ", " + second + " : False");
		}
	}
	
	//O(n) solution where n is the length of the longer word
	//This solution uses only 3 ints
	public static boolean checkEdit(String word1, String word2){
		if(word1.equals(word2)) //zero edits
			return true;
		else{
			int bitOne = 0;
			int bitTwo = 0;
			for(int i = 0; i < word1.length(); i++){ //get first word's bit vector
				int bitVal = word1.charAt(i) - 'a';
				if(bitVal < 0 || bitVal > 26){}
				else{
					if((bitOne & (1<<bitVal)) > 0)
						bitOne ^= 1<<bitVal;
					else
						bitOne |= 1<<bitVal;
				}
			}
			for(int i = 0; i < word2.length(); i++){ //get second word's bit vector
				int bitVal = word2.charAt(i) - 'a';
				if(bitVal < 0 || bitVal > 26){}
				else{
					if((bitTwo & (1<<bitVal)) > 0)
						bitTwo ^= 1<<bitVal;
					else
						bitTwo |= 1<<bitVal;
				}
			}
			int bitResult = bitOne ^ bitTwo; //find the letter(s) that are not common in both words
			if((bitResult & (bitResult-1)) == 0) //if the difference is a case of addition/removal of a letter
				return true;
			else if(((bitResult & (bitResult-1)) & (bitResult & (bitResult-1))-1) == 0) //if the difference is a change in one letter ie. pale => bale
				return true;
			else return false;
		}
	}
}
