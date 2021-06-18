package leetcode;

import util.ListNode;

public class ReverseLL {

	public static void main(String[] args) {
		
		ListNode root = new ListNode(1);
		root.setNext(new ListNode(2));
		root.getNext().setNext(new ListNode(3));
		root.getNext().getNext().setNext(new ListNode(4));
		
		System.out.println(root);
		
		ListNode newRoot = root;
		while(1==1) {
			newRoot = newRoot.getNext();
			if(newRoot.getNext()==null)
				break;
		}
		System.out.println("newRoot: "+newRoot);
		root = reverseLL(root);
		
		System.out.println(newRoot);
	}
	
	private static ListNode reverseLL(ListNode root) {
		
		if(root.getNext() == null)
			return root;
		
		ListNode nextNode = reverseLL(root.getNext());
		nextNode.setNext(root);
		root.setNext(null);
		
		return root; 
	}
	
}
