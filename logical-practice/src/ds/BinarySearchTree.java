package ds;

import util.BinaryTreeNode;

public class BinarySearchTree {

	private BinaryTreeNode root;
	public BinaryTreeNode getRoot() {return this.root;}
	
	public BinarySearchTree() {
		this.root = new BinaryTreeNode();
	}
	
	public BinarySearchTree(int val) {
		this.root = new BinaryTreeNode(val);
	}
	
	public BinaryTreeNode createBinaryTree(int[] arr) {
		
		root = new BinaryTreeNode();
		root.setVal(arr[0]);
		for(int i=1; i<arr.length; i++) {
			addNode(root, arr[i]);
		}
		return root;
	}
	
	public BinaryTreeNode createBinaryTree() {
		
		int[] arr = new int[] {	50, 
								25, 75, 
								13, 37, 63, 87,
								7, 20, 30, 44, 56, 70, 80, 94,
								5, 9, 18, 22, 28, 32, 42, 46, 54, 58, 68, 72, 78, 82, 92, 96};
		root = new BinaryTreeNode();
		root.setVal(arr[0]);
		for(int i=1; i<arr.length; i++) {
			addNode(root, arr[i]);
		}
		return root;
		
	}
	
	public void addNode(BinaryTreeNode root, int val) {
		
		if(val <= root.getVal()) {
			if(root.getL() == null)
				root.setL(new BinaryTreeNode(val, root));
			else
				addNode(root.getL(), val);
		} else {
			if(root.getR() == null)
				root.setR(new BinaryTreeNode(val, root));
			else
				addNode(root.getR(), val);
		}
		
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryTreeNode root = bst.createBinaryTree();
		System.out.println(root);
	}
	
}
