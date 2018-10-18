/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {
	public static void main(String[] args){
		LinkedListNode node = new LinkedListNode(1);
		node.append(1);
		node.append(13);
		node.append(13);
		node.append(21);
		node.append(51);
		node.append(1);
		node.append(111);
		LinkedListNode iter = node;
		while(iter != null){
			System.out.print(iter.data + "\t");
			iter = iter.next;
		}
		System.out.println();
		removeDups(node);
		LinkedListNode changed = node;
		while(changed != null){
			System.out.print(changed.data + "\t");
			changed = changed.next;
		}
	}

	//O(n^2) solution where n is the number of nodes in the linked list
	//uses O(1) space (single LinkedListNode object)
	public static void removeDups(LinkedListNode node){
		LinkedListNode p1 = node;
		while(p1.next != null){
			LinkedListNode p2 = p1;
			while(p2.next != null){
				if(p1.data == p2.next.data){//if p2.next is a duplicate, assign p2.next.next to it instead to delete the node
					p2.next = p2.next.next;
				}
				else p2 = p2.next;
			}
			p1 = p1.next;
		}
		while(p1.prev != null){ //go back to the beginning of the list
			p1 = p1.prev;
		}
		node = p1;
	}
}
