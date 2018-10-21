/*
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (eg. "waterbottle" : "erbottlewat")
 */
public class StringRotation {
	public static void main(String[] args){
		String word = "waterbottle";
		String rotation = "erbottlewat";
		if(isRotation(word, rotation))
			System.out.println(word + ", " + rotation + " : True");
		else 
			System.out.println(word + ", " + rotation + " : False");

	}
	
	//O(m*n) solution using a StringBuilder with a inital capacity large enough to store the string
	//isSubString is O(m*n) but can be reduced to O(n) if using the Boyer-More algorithm instead of indexOf
	public static boolean isRotation(String word, String rotation){
		StringBuilder build = new StringBuilder(word.length()*2);
		build.append(word);
		build.append(word);
		return isSubstring(build.toString(), rotation);
	}
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
