/*
 * Implement an algorithm to delete a node in the middle (ie. any node but the first and last node,
 * but not necessarily the exact middle) of a singly linked list, given only access to that node.
 */
public class DeleteMiddleNode {
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(4);
		node.appendSingle(1);
		node.appendSingle(13);
		node.appendSingle(2);
		node.appendSingle(9);
		node.appendSingle(200);
		node.appendSingle(25);
		delMidNode(node.next.next.next.next);
		while(node != null){
			System.out.print(node.data + "\t");
			node = node.next;
		}	
	}
	
	//O(1) solution although writing the tests in main felt kind of weird
	public static boolean delMidNode(LinkedListNode node){
		if(node == null || node.next == null){
			return false;
		}
		else{
			node.data = node.next.data;
			node.next = node.next.next;
		}
		return true;
	}
}
