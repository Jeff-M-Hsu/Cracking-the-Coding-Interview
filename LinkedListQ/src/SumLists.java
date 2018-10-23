/*
 * You have two numbers represented by linked lists, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 */
public class SumLists {
	public static void main(String[] args){
		LinkedListNode num1 = new LinkedListNode(0);
		num1.appendSingle(1);
		num1.appendSingle(4);
		//reverse : num1 = 410
		//forward : num1 = 014

		LinkedListNode num2 = new LinkedListNode(2);
		num2.appendSingle(3);
		num2.appendSingle(6);
		num2.appendSingle(1);
		//reverse : num2 = 1632
		//forward : num2 = 2361

		LinkedListNode reverse = sumListsReverse(num1, num2);
		//LinkedListNode forward = sumListsForward(num1, num2);
		//reverse : 410 + 1632 = 2042, or 2-4-0-2
		//forward : 014 + 2361 = 2375, or 2-3-7-5
		int reverseAns = 0;
		int forwardAns = 0;
		int exp = 0;
		//int length = forward.length()-1;
		while(reverse != null){
			reverseAns += reverse.data * Math.pow(10, exp);
			reverse = reverse.next;
			exp++;
		}
		/*while(forward != null){
			forwardAns += forward.data * Math.pow(10, length);
			forwardAns = forward.next;
			length--;
		}
		*/
		System.out.println("Reverse : " + reverseAns);
		//System.out.println("Forward : " + forwardAns);
	}

	//O(n) solution with O(2n) or O(n) space that creates a node after adding values from one or both lists depending on length.
	//If sum is greater than 10 then integer divide to get the amount of carry over and mod(10) to get the result of the current node.
	public static LinkedListNode sumListsReverse(LinkedListNode num1, LinkedListNode num2){
		int carry = 0;
		LinkedListNode result = new LinkedListNode(num1.data + num2.data);
		LinkedListNode head = result; //pointer that stays at the head of result list
		if(result.data >= 10){
			carry = result.data/10;
			result.data = result.data % 10;
		}
		num1 = num1.next;
		num2 = num2.next;
		while(num1 != null || num2 != null){ //need to account for lists of different lengths
			if(num1 == null){
				result.next = new LinkedListNode(num2.data + carry);
				carry = 0;
				num2 = num2.next;
			}
			else if(num2 == null){
				result.next = new LinkedListNode(num1.data + carry);
				carry = 0;
				num1 = num1.next;
			}
			else{
				result.next = new LinkedListNode(num1.data + num2.data + carry);
				carry = 0;
				if(result.next.data >= 10){ //if sum > 10 then integer divide to find the 10's digit and mod(10) to find the 1's digit
					carry = result.next.data/10;
					result.next.data = result.next.data % 10;
				}
				num1 = num1.next;
				num2 = num2.next;
			}
			result = result.next;
		}
		return head;
	}
}
