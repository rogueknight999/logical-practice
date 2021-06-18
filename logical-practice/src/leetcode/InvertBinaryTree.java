package leetcode;

import ds.Node;

/*
 * ip: 
 * 		  1
 * 		/   \
 *     2     3
 * 	  / \   / \
 * 	 4	 5	6  7
 *	/ \	
 * 8   9
 * 
 * op:
 * 		  1
 * 		/   \
 *     3     2
 * 	  / \   / \
 * 	 7	 6	5  4
 * 			  / \
 *           9   8
 * 
 */
public class InvertBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(root);
		
		invert(root);
		
		System.out.println(root);
	}
	
	private static void invert(Node root) {
		
		if(root==null)
			return;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invert(root.left);
		invert(root.right);
		
	}
	
}
