package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ds.BinarySearchTree;
import util.BinaryTreeNode;

public class BFSBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinarySearchTree().createBinaryTree();
		System.out.println(root);
		
		List<Integer> bfsValues = new ArrayList<Integer>();
		BFSBinaryTree tree = new BFSBinaryTree();
		tree.buildBfs(bfsValues, root);
		
		for(int i : bfsValues) {
			System.out.print(i+", ");
		}
	}
	
	public void buildBfs(List<Integer> values, BinaryTreeNode root){
		
		List<BinaryTreeNode> l1 = new LinkedList<BinaryTreeNode>();
		l1.add(root);
		List<BinaryTreeNode> l2 = new LinkedList<BinaryTreeNode>();
		
		while(!l1.isEmpty() || !l2.isEmpty()) {
			while(!l1.isEmpty()) {
				BinaryTreeNode node = l1.remove(0);
				values.add(node.getVal());
				if(node.getL()!=null)
					l2.add(node.getL());
				if(node.getR()!=null)
					l2.add(node.getR());
			}
			while(!l2.isEmpty()) {
				BinaryTreeNode node = l2.remove(0);
				values.add(node.getVal());
				if(node.getL()!=null)
					l1.add(node.getL());
				if(node.getR()!=null)
					l1.add(node.getR());
			}
		}
		
	}
	
}
