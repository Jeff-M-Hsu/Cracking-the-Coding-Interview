/*
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string. You can
 * assume the string has only upper and lower case letters.
 */
public class StringCompression {
	public static void main(String[] args){
		String[] words = {"aaabbbcccabb", "aaabbbcccaaa", "aaaaa", "abcabcabcabc"};
		for(String w : words){
			System.out.println(compress(w));
		}
	}
	
	//This solution is O(n) in cases where the compressed string is shorter than the original. 
	//Worst case would still be O(n^2). However, we can re-purpose the code that performs the 
	//compression to count the final length of the resultant string and create a StringBuilder 
	//of that size to maintain a O(n) runtime for all cases in exchange for ~2x the amount of code.
	public static String compress(String word){
		StringBuilder result = new StringBuilder(word.length());
		char c = word.charAt(0);
		int count = 1;
		for(int i = 1; i < word.length(); i++){
			if(word.charAt(i) == c)
				count++;
			else{
				result.append(c);
				result.append(count);
				c = word.charAt(i);
				count = 1;
			}
		}
		result.append(c);
		result.append(count);
		if(result.length() > word.length())
			return word;
		else return result.toString();
	}
}
