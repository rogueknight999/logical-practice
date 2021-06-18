package util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	int val;
	List<TreeNode> children;
	
	public TreeNode() {
		children = new ArrayList<TreeNode>();
	}

	public int getVal() {return val;}
	public TreeNode setVal(int val) {
		this.val = val;
		return this;
	}

	public List<TreeNode> getChildren() {return children;}
	public TreeNode setChildren(List<TreeNode> children) {
		this.children = children;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + val;
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
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (val != other.val)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = "{\"val\":{" + val + ", \"children\": "; 
		for(TreeNode child : children) {
			str += child.toString();
		}		
		str += "}";
		
		return str;
	}
	
}
