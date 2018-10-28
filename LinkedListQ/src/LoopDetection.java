/*
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 */
public class LoopDetection {
	public static void main(String[] args){
		LinkedListNode loop = new LinkedListNode(3);
		loop.appendSingle(4);
		loop.appendSingle(5);
		
		LinkedListNode node = new LinkedListNode(0);
		node.appendSingle(1);
		node.appendSingle(2);
		node.appendSingle(loop);
		node.appendSingle(loop);
		
		LinkedListNode result = detectLoop(node);
		if(result != null)
			System.out.println("Node : " + result.data);
		else
			System.out.println("No loop detected");
	}
	
	//O(n) solution where n is the number of steps from the head of the linked list
	public static LinkedListNode detectLoop(LinkedListNode node){
		LinkedListNode head = node;
		LinkedListNode runner = node;
		//find where any part of the loop occurs
		while(runner.next != null){
			node = node.next;
			runner = runner.next.next;
			if(node == runner){
				break; //found meeting point where node is n steps from the head and runner is n steps from the beginning of the loop where it repeats
			}
		}
		//no loop detected
		if(runner == null){
			return null;
		}
		//start from the head of the list and have both pointers move at same speed
		//eventually both will land on the node that starts the loop because they are the same distance away from it
		else{
			node = head;
			while(runner != node){
				node = node.next;
				runner = runner.next;
			}
			return runner;
		}
	}

}
