package algo;

import java.util.ArrayList;
import java.util.List;

import ds.BinarySearchTree;
import util.BinaryTreeNode;

public class DFSBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinarySearchTree().createBinaryTree();
		System.out.println(root);
		
		List<Integer> dfsValues = new ArrayList<Integer>();
		DFSBinaryTree tree = new DFSBinaryTree();
		tree.buildDfs(dfsValues, root);
		
		for(int i : dfsValues) {
			System.out.print(i+" ");
		}
	}
	
	void buildDfs(List<Integer> values, BinaryTreeNode root) {
		
		if(root.getL()!=null) 
			buildDfs(values, root.getL());
		values.add(root.getVal());
		if(root.getR()!=null) 
			buildDfs(values, root.getR());
		
	}
	
}
