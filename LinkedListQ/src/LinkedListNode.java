
public class LinkedListNode {
	public LinkedListNode last, prev, next;
	public int data;
	
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){
		data = d;
		prev = p;
		next = n;
	}
	
	public LinkedListNode(int d){
		data = d;
	}
	
	public LinkedListNode(){}
	
	public void setNext(LinkedListNode n){
		next = n;
		if(this == last)
			last = n;
		if(n != null && n.prev != this) //if next node n is not null and the parent of n is not this, set the parent of n to this
			n.setPrev(this);
	}
	
	public void setPrev(LinkedListNode p){
		prev = p;
		if(p != null && p.next != this) //if prev node p is not null and the child of p is not this, set the child of p to this
			p.setNext(this);
	}
	
	public void append(int d){
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){
			LinkedListNode p = n;
			n = n.next;
			n.prev = p;
			
		}
		n.next = end;
		end.prev = n;
	}
	
	public void appendSingle(int d){
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while(n.next != null){
			n = n.next;
			
		}
		n.next = end;
	}
	
	public LinkedListNode clone(){
		LinkedListNode next2 = null;
		if(next != null){
			next2 = next.clone(); //recursive call to the end of the list
		}
		//create new list from the end by adding each one as the new head and returning the updated list
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}
}
