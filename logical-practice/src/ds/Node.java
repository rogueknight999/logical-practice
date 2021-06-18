package ds;

public class Node{

	public Node left;
	public Node right;
	public int val;
	
	public Node(int val) {this.val = val;}
	
	public Node(Node left, Node right, int val) {
		this.left=left;
		this.right=right;
		this.val=val;
	}
	
	@Override
	public String toString() {
		
		return "["+val+" L->"+left+" R->"+right+"]";
		
	}
	
}
