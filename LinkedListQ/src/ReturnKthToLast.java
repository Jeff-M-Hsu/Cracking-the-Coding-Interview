/*
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(1);
		node.appendSingle(1);
		node.appendSingle(13);
		node.appendSingle(13);
		node.appendSingle(21);
		node.appendSingle(51);
		node.appendSingle(1);
		node.appendSingle(111);
		LinkedListNode iter = node;
		while(iter != null){
			System.out.print(iter.data + "\t");
			iter = iter.next;
		}
		System.out.println();
		LinkedListNode result = countK(node, 4);
		System.out.print(result.data);
	}
	
	//O(n) solution by iterating through the list and counting the nodes
	//then finding the kth to last via count - k, and I believe uses O(1) space?
	public static LinkedListNode countK(LinkedListNode input, int k){
		int count = 0;
		int index = 0;
		LinkedListNode n = input;
		while(n != null){
			count++;
			n = n.next;
		}
		index = count-k;
		if(index < 0)
			return new LinkedListNode();
		else{
			for(int i = 0; i < index; i++){
				input = input.next;
			}
		}
		return input;
	}
}
