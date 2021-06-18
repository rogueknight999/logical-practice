package ds;

import util.BinaryTreeNode;

public class AVLTree {

	private int balanceFactor = 1;
	private String insertionPath="";
	private int balancingNode=0;

	private BinaryTreeNode root;
	public BinaryTreeNode getRoot() {return this.root;}
	
	public AVLTree() {
		this.root = new BinaryTreeNode();
	}
	
	public AVLTree(int val) {
		this.root = new BinaryTreeNode(val);
	}
	
	public BinaryTreeNode createAVLTree(int[] arr) {
		
		root = new BinaryTreeNode();
		root.setVal(arr[0]);
		for(int i=1; i<arr.length; i++) {
			addNode(root, arr[i]);
		}
		return root;
	}
	
	public BinaryTreeNode createAVLTree() {
		
		//int[] arr = new int[] {10,9,8,7,6,5,4,3,2,1}; //LL Rotation
		//int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10}; //RR Rotation
		//int[] arr = new int[] {10,5,15,4,6,14,16,3,7,8,9};
		//int[] arr = new int[] {10,20,30,40,50,25};
		int[] arr = new int[] {2, 4, 1, 3, 5, 6, 7};
		
		root = new BinaryTreeNode();
		root.setVal(arr[0]);
		for(int i=1; i<arr.length; i++) {
			System.out.println("Adding "+arr[i]);
			addNode(root, arr[i]);
			System.out.println(root);
			System.out.println();
		}
		return root;
		
	}
	
	public void addNode(BinaryTreeNode root, int val) {
		
		balancingNode++;
		if(val <= root.getVal()) {
			insertionPath += "L";
			if(root.getL() == null) {
				BinaryTreeNode node = new BinaryTreeNode(val, root);
				root.setL(node);
				balance(node);
			}
			else {
				addNode(root.getL(), val);
			}
		} else {
			insertionPath += "R";
			if(root.getR() == null) {
				BinaryTreeNode node = new BinaryTreeNode(val, root);
				root.setR(node);
				balance(node);
			}
			else {
				addNode(root.getR(), val);
			}
		}
		
	}
	
	private void balance(BinaryTreeNode node) {
		System.out.println("balance called for "+node.getVal());

		int currBalance = node.getlHeight() - node.getrHeight();
		if(currBalance<=balanceFactor && currBalance>=-balanceFactor) {
			if(node.getParent()!=null) {
				balancingNode--;
				
				balance(node.getParent());
			}
			else if(node.getParent()==null)
				System.out.println("Tree is Balanced");
		} else {
			String path = "";
			path = insertionPath.substring(balancingNode, balancingNode+2);
			
			if(path.equals("LL"))
				LLRotate(node);
			else if(path.equals("LR"))
				LRRotate(node);
			else if(path.equals("RL"))
				RLRotate(node);
			else if(path.equals("RR"))
				RRRotate(node);

			if(node.getParent()!=null)
				balance(node.getParent());
		}
		
		balancingNode=0;
		insertionPath = "";
	}
	
	private void LLRotate(BinaryTreeNode node) {
		System.out.println("Rotating LL for: "+node.getVal());
		
		BinaryTreeNode parent = node.getParent();
		BinaryTreeNode l1 = node.getL();
		BinaryTreeNode l1r = l1.getR();
		
		l1.setParent(parent);
		if(parent==null) {
			root = l1;
		} else {
			if(node.getVal()<=parent.getVal())
				parent.setL(l1);
			else
				parent.setR(l1);
		}

		l1.setR(node);
		node.setParent(l1);
		node.setL(l1r);
		if(l1r!=null) {
			l1r.setParent(node);
			l1r.updateHeights();
		}
		
		System.out.println("LL Rotation complete: "+root);
	}
	
	private void LRRotate(BinaryTreeNode node) {
		System.out.println("Rotating LR");
		
		BinaryTreeNode parent = node.getParent();
		BinaryTreeNode l1 = node.getL();
		BinaryTreeNode l1r = l1.getR();
		BinaryTreeNode l1rl = l1r.getL();
		BinaryTreeNode l1rr = l1r.getR();
		
		l1r.setParent(parent);
		if(parent == null) {
			root = l1r;
		} else {
			if(l1r.getVal()<=parent.getVal())
				parent.setL(l1r);
			else
				parent.setR(l1r);
		}
		
		l1r.setL(l1);
		l1.setParent(l1r);
		l1.setR(l1rl);
		if(l1rl!=null) {
			l1rl.setParent(l1);
			l1rl.updateHeights();
		}
		l1r.setR(node);
		node.setParent(l1r);
		node.setL(l1rr);
		if(l1rr!=null) {
			l1rr.setParent(node);
			l1rr.updateHeights();
		}
		
		System.out.println("LR Rotation complete: "+root);
	}
	
	private void RLRotate(BinaryTreeNode node) {
		System.out.println("Rotating RL");
		
		BinaryTreeNode parent = node.getParent();
		BinaryTreeNode r1 = node.getR();
		BinaryTreeNode r1l = r1.getL();
		BinaryTreeNode r1ll = r1l.getL();
		BinaryTreeNode r1lr = r1l.getR();
		
		r1l.setParent(parent);
		if(parent == null) {
			root = r1l;
		} else {
			if(r1l.getVal()<=parent.getVal())
				parent.setL(r1l);
			else
				parent.setR(r1l);
		}
		
		r1l.setR(r1);
		r1.setParent(r1l);
		r1.setL(r1lr);
		if(r1lr!=null) {
			r1lr.setParent(r1);
			r1lr.updateHeights();
		}
		r1l.setL(node);
		node.setParent(r1l);
		node.setR(r1ll);
		if(r1ll!=null) {
			r1ll.setParent(node);
			r1ll.updateHeights();
		}
		
		System.out.println("RL Rotation complete: "+root);
	}

	private void RRRotate(BinaryTreeNode node) {
		System.out.println("Rotating RR");

		BinaryTreeNode parent = node.getParent();
		BinaryTreeNode r1 = node.getR();
		BinaryTreeNode r1l = r1.getL();
		
		r1.setParent(parent);
		if(parent==null) {
			root = r1;
		} else {
			if(node.getVal()<=parent.getVal())
				parent.setL(r1);
			else
				parent.setR(r1);
		}
		
		r1.setL(node);
		node.setParent(r1);
		node.setR(r1l);
		if(r1l!=null) {
			r1l.setParent(node);
			r1l.updateHeights();
		}
		
		System.out.println("RR Rotation Complete: "+root);
	}

	
	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		BinaryTreeNode root = bst.createAVLTree();
		System.out.println("Tree creation complete");
		System.out.println(root);
	}
	
}
