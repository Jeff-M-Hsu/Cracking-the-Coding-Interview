/*
 * Implement a function to check if a linked list is a palindrome
 */
public class Palindrome {
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(5);
		node.appendSingle(4);
		node.appendSingle(3);
		node.appendSingle(1);
		node.appendSingle(3);
		node.appendSingle(4);
		node.appendSingle(5);
		//list is 5-4-3-1-3-4-5
		
		LinkedListNode node2 = new LinkedListNode(5);
		node2.appendSingle(4);
		node2.appendSingle(3);
		node2.appendSingle(3);
		node2.appendSingle(4);
		node2.appendSingle(5);
		//list is 5-4-3-3-4-5
		if(palindrome(node)) System.out.println("True");
		else System.out.println("False");
		if(palindrome(node2)) System.out.println("True");
		else System.out.println("False");
		
	}

	//O(n)^2 brute force by finding the middle and tail of the list, 
	//iterating backwards from the tail by finding the kth last node
	//at the same speed that head iterates towards the middle node
	//until both head and tail meet in the middle node
	public static boolean palindrome(LinkedListNode node){
		int count = 1;
		int mod;
		LinkedListNode tail = node;
		LinkedListNode head = node;
		LinkedListNode middle = node;
		//O(n)
		while(tail.next != null){
			count++;
			tail = tail.next;
		}
		//O(n)
		for(int i = 0; i < (count/2); i++){
			middle = middle.next;
		}
		mod = count;
		//O(n/2)^2 = O(n)^2
		if(count % 2 == 1) mod++;
		while(head.data != middle.data){
			tail = middle;
			for(int i = (mod-2)/2; i > 0; i--){
				tail = tail.next;
			}
			if(head.data != tail.data){
				return false;
			}else{
				head = head.next;
				mod--;
				if(count % 2 == 1) mod--;
			}
		}
		return true;
	}
}
