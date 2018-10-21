//This one is a bit weird to understand, personally I would much rather spend the extra space copying strings in Java
/*
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the 
 * end to hold the additional characters, and that you are given
 * the 'true' length of the string. (Note: If implementing in Java,
 * please use a character array so that you can perform this operation in place.)
 */
public class URLify {
	public static void main(String[] args) {
		String[][] pairs = {{"Mr John Smith    ", "13"}, {"Mr Bond   ", "7"}, {"L e e t         ", "7"}};
		for(String[] pair : pairs) {
			String name = pair[0];
			String length = pair[1];
			char[] charName = name.toCharArray();
			urlify(charName, length);
			System.out.println(new String(charName));
		}
	}
	
	//O(n) performs n operations and uses O(1) space due to directly editing the input
	public static void urlify(char[] name, String length) {
		int trueLength = Integer.parseInt(length);
		int count = 0;
		int index = 0;
		for(int i = 0; i < trueLength; i++) {
			if(name[i] == ' ')
				count++;
		}
		index = trueLength + count*2;
		if(trueLength < name.length)
			name[trueLength] = '\0';
		for(int i = trueLength-1; i >= 0; i--) {
			if(name[i] == ' ') {
				name[index-1] = '0';
				name[index-2] = '2';
				name[index-3] = '%';
				index -= 3;
			}
			else {
				name[index-1] = name[i];
				index--;
			}
		}
	}
}
