package logical;

import ds.Node;

/*
 * 					1
 * 			2				3
 * 		4		5		6		7
 * 		  8					  9
 * 
 *  op: 8 4 2 1 3 7 9
 */
public class OutlineOfTree {

	static int leftLevel=0;
	static int rightLevel=0;
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.right = new Node(8);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(9);
		
		/*Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(10);*/
		
		left(root);
		right(root.right);
	}
	
	public static void left(Node root) {
		
		if(root==null) return;
		
		if(root.left!=null)
			left(root.left);
		else
			left(root.right);
		
		System.out.print(root.val+" ");
	}
	
	public static void right(Node root) {
		
		if(root==null) return;
		
		System.out.print(root.val+" ");
		
		if(root.right!=null)
			right(root.right);
		else
			right(root.left);
	}
	
}