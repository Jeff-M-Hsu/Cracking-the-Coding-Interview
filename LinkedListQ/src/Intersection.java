/*
 * Given two singly linked lists, determine if they intersect. Return the intersecting node.
 * Note that intersection is based on reference, not value.
 */
public class Intersection {
	public static void main(String[] args){
		LinkedListNode intersect = new LinkedListNode(0);
		intersect.appendSingle(2);
		
		LinkedListNode list1 = new LinkedListNode(8);
		list1.appendSingle(5);
		list1.appendSingle(intersect);

		LinkedListNode list2 = new LinkedListNode(4);
		list2.appendSingle(3);
		list2.appendSingle(intersect);

		LinkedListNode result = intersect(list1, list2);
		if(result != null){
			System.out.println("Intersecting node: " + result.data);
		}
		else System.out.println("Lists do not intersect");
	}
	
	//O(n^2) brute force solution, checks all of list2 for each node in list1.
	//The most obvious but probably one of the worst performing solutions
	public static LinkedListNode intersect(LinkedListNode list1, LinkedListNode list2){
		LinkedListNode result = null;
		LinkedListNode head2 = list2;
		while(list1 != null){
			while(list2 != null){
				if(list1 == list2){
					return result = list1;
				}
				else list2 = list2.next;
			}
			list1 = list1.next;
			list2 = head2;
		}

		return result;
	}
}
