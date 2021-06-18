package util;

public class BST {

	private Node root;
	
	BST(int value){
		root = new Node(value, null, null);
	}
	
	public Node getRoot() {return root;}
	public void setRoot(Node root) {this.root = root;}

	void add(int value) {
		add(value, this.root);
	}
	
	private void add(int value, Node root) {
		if(value < root.value) {
			if(root.left == null)
				root.left = new Node(value, null, null);
			else 
				add(value, root.left);
		} else {
			if(root.right == null)
				root.right = new Node(value, null, null);
			else
				add(value, root.right);
		}
	}
	
}

class Node{
	
	public int value;
	public Node left;
	public Node right;
	
	Node(int value, Node left, Node right){
		this.value=value;
		this.left=left;
		this.right=right;
	}

	Node(){}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + value;
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
		Node other = (Node) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
}