package logical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
public class VerticalBinaryTree {
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter IP");
		String[] ip = sc.nextLine().trim().split(" ");
		
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for(int i=0; i<ip.length; i+=3) {
			nodes.add(new TreeNode(Integer.parseInt(ip[i]), Integer.parseInt(ip[i+1]), ip[i+2]));
		}
		
		nodes.add(0, new TreeNode(null, nodes.get(0).root, null));
		
		TreeNode prevNode = nodes.get(0);
		List<NodeLocation> tree = new ArrayList<NodeLocation>();
		tree.add(new NodeLocation(0, 0, prevNode.value));
		for(int i=1; i<nodes.size(); i++) {
			NodeLocation n = null;
			TreeNode currNode = nodes.get(i);
			for(int j=tree.size()-1; j>=0; j--) {
				n = tree.get(j);
				if(currNode.root == n.value)
					break;
			}
			
			if(currNode.pos.equalsIgnoreCase("L")) {
				tree.add(new NodeLocation(n.x-1, n.y+1, currNode.value));				
			}
			else if(currNode.pos.equalsIgnoreCase("R")) {
				tree.add(new NodeLocation(n.x+1, n.y+1, currNode.value));
			} else {
				System.out.println("No Valid Position found");
			}
		}
		Collections.sort(tree);
		for(NodeLocation node : tree)
			System.out.print(node.value+",");
	}
	
}

class TreeNode{
	Integer root;
	Integer value;
	String pos;
	TreeNode(Integer root, Integer value, String pos){
		this.root=root;
		this.value=value;
		this.pos=pos;
	}
	@Override
	public String toString() {
		return "TreeNode [root=" + root + ", value=" + value + ", pos=" + pos + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TreeNode other = (TreeNode) obj;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}

@SuppressWarnings("rawtypes")
class NodeLocation implements Comparable{
	Integer x;
	Integer y;
	Integer value;
	public NodeLocation(Integer x, Integer y, Integer value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	@Override
	public String toString() {
		return "NodeLocation [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		NodeLocation other = (NodeLocation) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		NodeLocation node = (NodeLocation) o;
		if(this.x < node.x)
			return -1;
		else if (this.x > node.x)
			return 1;
		else if(this.x == node.x) {
			if(this.y < node.y)
				return -1;
			else if(this.y > node.y)
				return 1;
			else if(this.y == node.y)
				return 0;
			else 
				return 0;
		} else
			return 0;
	}
}


