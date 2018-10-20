/*
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x. If x is contained within the list, the
 * values of x only need to be after the elements less than x. The partition element x can appear
 * anywhere in the right partition; it does not need to appear between the left and right partitions.
 */
public class Partition {
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(3);
		node.appendSingle(5);
		node.appendSingle(8);
		node.appendSingle(5);
		node.appendSingle(10);
		node.appendSingle(2);
		node.appendSingle(1);
		node = wtf(node, 5);
		while(node != null){
			System.out.print(node.data + "\t");
			node = node.next;
		}
	}

	//O(n^2) solution with O(1) space, move all elements greater or equal to x to a separate list
	//then combine the two at the end
	public static void partition(LinkedListNode node, int x){
		LinkedListNode right = new LinkedListNode();
		while(node.next != null){
			if(node.next.data < 5){
				node = node.next;
			}
			else{
				right.appendSingle(node.next.data);
				node.next = node.next.next;
			}
		}
		node.next = right.next;
	}

	//O(
	public static LinkedListNode wtf(LinkedListNode node, int x){
		LinkedListNode head = node;
		LinkedListNode tail = head;
		while(node!=null){
			LinkedListNode next = node.next;
			if(node.data < x){
				node.next = head;
				head = node;
			}
			else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
}

