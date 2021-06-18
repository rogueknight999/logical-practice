package logical;

import ds.Node;

/*
 * 					1
 * 			2				3
 * 				5		6		7
 * 		  					  9
 * 
 *  op: 1 2 5 9
 */
public class LeftViewOfTree {

	static int maxLevel=0;
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.right = new Node(5);
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
		
		getLeftView(root, 1);
	}
	
	static void getLeftView(Node root, int level){
		
		if(root==null) return;
		
		if(level>maxLevel) {
			System.out.print(root.val+" ");
			maxLevel = level;
		}
		
		getLeftView(root.left, level+1);
		getLeftView(root.right, level+1);
				
	}
	
}