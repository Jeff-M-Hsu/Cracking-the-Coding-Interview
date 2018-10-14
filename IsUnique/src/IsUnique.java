
public class IsUnique {
	public static void main(String args[]) {
		if(isUnique(args[0]))
			System.out.println("Unique");
		else
			System.out.println("Not Unique");
	}
//abcde
//aabcd
	public static boolean isUnique(String input) {
		for(int i = 0; i < input.length()-1; i++) {
			char c = input.charAt(i);
			for(int j = i+1; j < input.length(); j++) {
				if(input.charAt(j) == c) {
					return false;
				}
			}
		}
		return true;
	}
}

