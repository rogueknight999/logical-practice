package ds;

import util.ListNode;

public class LinkedList {

	private final ListNode head;
	public ListNode getHead() {return head;}

	private final ListNode tail;
	public ListNode getTail() {return tail;}
	
	private int listLength;
	public int getListLength() {return listLength;}
	
	private boolean isDoubly;
	public boolean doubly() {return isDoubly;}
	
	public LinkedList(boolean isDoubly) {
		this.head = new ListNode();
		this.tail = new ListNode();
		
		this.head.setNext(tail);
		
		if(isDoubly)
			this.tail.setPrev(head);
		
		this.listLength = 0;
		this.isDoubly = isDoubly;
	}
	
	public LinkedList() {
		this.head = new ListNode();
		this.tail = new ListNode();
		
		this.head.setNext(tail);
		
		this.listLength = 0;
		this.isDoubly = false;
	}

	public void add(int val) {
		add(this.head, 0, listLength, val);
	}
	
	public void add(int index, int val) {
		if(index>this.listLength) {
			index=listLength;
		}
		add(this.head, 0, index, val);
	}
	
	private void add(ListNode node, int currIndex, int index, int val) {
		
		if(currIndex<index) {
			currIndex++;
			add(node.getNext(), currIndex, index, val);
		} else {
			createNode(node, val);
		}
	}
	
	private void createNode(ListNode node, int val) {
		
		ListNode newNode = new ListNode();
		newNode.setVal(val);
		newNode.setNext(node.getNext());
		
		if(isDoubly) {
			newNode.setPrev(node);
			node.getNext().setPrev(newNode);
		}

		node.setNext(newNode);
		
		listLength++;
	}
	
	@Override
	public String toString() {
		
		String listString = "Head";
		ListNode node = head.getNext();
		
		while(node!=null) {
			if(node.getVal()!=null)
				listString += " -> "+node.getVal();
			else
				listString += " -> Tail";
			node = node.getNext();
		}
		
		return listString;
	}
	
	public String toStringReverse() {
		
		String listString;
		if(isDoubly) {
			listString = "Tail";
			ListNode node = tail.getPrev();
			
			while(node!=null) {
				if(node.getVal()!=null)
					listString += " -> "+node.getVal();
				else
					listString += " -> Head";
				node = node.getPrev();
			}
		} else {
			listString = "Cannot print SinglyLinkedList in reverse order.";
		}
		
		return listString;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(true);

		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list);
		
		list.add(0, 5);
		System.out.println(list);
		
		list.add(2,15);
		System.out.println(list);
		
		list.add(10, 40);
		System.out.println(list);
		
		System.out.println(list.toStringReverse());
	}
	
}
