package logical;

import util.ListNode;

public class CopyLLWithRandomPointer {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		n1.setPrev(n3);
		n2.setPrev(n4);
		n3.setPrev(n5);
		n4.setPrev(n2);
		n5.setPrev(n1);

		ListNode node = n1;
		
		node = n1;
		while(true) {
			boolean loop = true;
			if(node.getNext()==null)
				loop = false;
			
			System.out.print(node.getPrev().getVal()+", ");

			if(!loop)
				break;
			node = node.getNext();
		}
		System.out.println();
		
		node = n1;
		while(true) {
			boolean loop = true;
			if(node.getNext()==null)
				loop = false;
			
			ListNode temp = new ListNode();
			temp.setVal(node.getVal());
			temp.setNext(node.getNext());
			node.setNext(temp);

			if(!loop)
				break;
			node = temp.getNext();
		}
		System.out.println("Parse1 complete");
		
		node = n1;
		while(true) {
			boolean loop = true;
			if(node.getNext()==null)
				loop = false;
			System.out.print(node.getVal()+", ");
			if(!loop)
				break;
			node = node.getNext();
		}
		System.out.println();
		
		node = n1;
		while(true) {
			ListNode dummy = node.getNext();
			
			dummy.setPrev(node.getPrev().getNext());
			
			node = dummy.getNext();
			if(node==null)
				break;
		}
		System.out.println("Parse2 complete");
		
		node=n1;
		while(true) {
			System.out.print(node.getPrev().getVal()+", ");
			node = node.getNext();
			if(node==null)
				break;
		}
		System.out.println();
		
		node=n1;
		ListNode dummyStart = n1.getNext();
		while(true) {
			ListNode dummy = node.getNext();
			node.setNext(node.getNext().getNext());
			if(dummy.getNext()!=null)
				dummy.setNext(dummy.getNext().getNext());
			else
				dummy.setNext(null);
			node = node.getNext();
			if(node==null)
				break;
		}
		System.out.println("Parse3 Complete");

		node=n1;
		System.out.print("Orignal: ");
		while(true) {
			System.out.print(node.getPrev().getVal()+", ");
			node = node.getNext();
			if(node==null)
				break;
		}
		System.out.println();
		
		node=dummyStart;
		System.out.print("Dummy: ");
		while(true) {
			System.out.print(node.getPrev().getVal()+", ");
			node = node.getNext();
			if(node==null)
				break;
		}
	}
	
}
