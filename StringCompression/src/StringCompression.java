/*
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string. You can
 * assume the string has only upper and lower case letters.
 */
public class StringCompression {
	public static void main(String[] args){
		String[] words = {"aaaaa", "aaabbbcccaaa", "abcabcabcabc"};
		for(String w : words){
			System.out.println(compress(w));
		}
	}
	
	//O(n) brute force solution
	public static String compress(String word){
		String result = "";
		char c = word.charAt(0);
		int count = 1;
		for(int i = 1; i < word.length(); i++){
			if(word.charAt(i) == c)
				count++;
			else{
				result += "" + c + "" + count;
				c = word.charAt(i);
				count = 1;
			}
		}
		result += "" + c + "" + count;
		if(result.length() > word.length())
			return word;
		else return result;
	}
}
