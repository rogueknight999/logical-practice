package util;

public class ListNode {

	Integer val;
	ListNode next;
	ListNode prev;
	
	public ListNode() {}
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public Integer getVal() {return val;}
	public ListNode setVal(Integer val) {
		this.val = val;
		return this;
	}
	
	public ListNode getNext() {return next;}
	public ListNode setNext(ListNode l1) {
		this.next = l1;
		return this;
	}
	
	public ListNode getPrev() {return prev;}
	public ListNode setPrev(ListNode l2) {
		this.prev = l2;
		return this;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((prev == null) ? 0 : prev.hashCode());
		result = prime * result + val;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (prev == null) {
			if (other.prev != null)
				return false;
		} else if (!prev.equals(other.prev))
			return false;
		if (val != other.val)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return val + " -> " + next;
	}
	
}
