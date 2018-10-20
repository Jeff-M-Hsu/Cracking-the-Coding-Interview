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
	
	//O(n) solution by using a forward pointer that started at the kth node
	//and iterated through the list. When the forward pointer reaches the end
	//the normal pointer is at the kth to last element
	//Note: solution from previous commit was more complicated and was technically O(2n-k) instead of the O(n) that this is
	public static LinkedListNode countK(LinkedListNode input, int k){
		if(k < 1) return new LinkedListNode();
		LinkedListNode forwardPointer = input;
		for(int i = 0; i < k; i++){
			if(forwardPointer == null) return new LinkedListNode();
			forwardPointer = forwardPointer.next;
		}
		while(forwardPointer != null){
			input = input.next;
			forwardPointer = forwardPointer.next;
		}
		return input;
	}
}
