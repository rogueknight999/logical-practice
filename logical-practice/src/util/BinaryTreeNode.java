package util;

public class BinaryTreeNode{
	
	int val;
	BinaryTreeNode parent;
	BinaryTreeNode l;
	BinaryTreeNode r;
	int height;
	int lHeight;
	int rHeight;
	
	public BinaryTreeNode() {
		this.height=0;
		this.lHeight=-1;
		this.rHeight=-1;
		
		updateHeights();
	}
	
	public BinaryTreeNode(int val) {
		this.val=val;
		this.height=0;
		this.lHeight=-1;
		this.rHeight=-1;
		
		updateHeights();
	}
	
	public BinaryTreeNode(int val, BinaryTreeNode parent) {
		this.val=val;
		this.parent=parent;
		this.height=0;
		this.lHeight=-1;
		this.rHeight=-1;
		
		updateHeights();
	}
	
	public int getVal() {return val;}
	public BinaryTreeNode setVal(int val) {
		this.val = val;
		return this;
	}
	
	public BinaryTreeNode getParent() {return parent;}
	public BinaryTreeNode setParent(BinaryTreeNode parent) {
		this.parent = parent;
		return this;
	}
	
	public BinaryTreeNode getL() {return l;}
	public BinaryTreeNode setL(BinaryTreeNode l) {
		this.l = l;
		if(this.l!=null)
			this.l.updateHeights();
		else
			this.updateHeights();
		return this;
	}
	
	public BinaryTreeNode getR() {return r;}
	public BinaryTreeNode setR(BinaryTreeNode r) {
		this.r = r;
		if(this.r!=null)
			this.r.updateHeights();
		else
			this.updateHeights();
		return this;
	}
	
	public int getHeight() {return height;}
	public BinaryTreeNode setHeight(int height) {
		this.height = height;
		return this;
	}
	
	public int getlHeight() {return lHeight;}
	public BinaryTreeNode setlHeight(int lHeight) {
		this.lHeight = lHeight;
		return this;
	}
	
	public int getrHeight() {return rHeight;}
	public BinaryTreeNode setrHeight(int rHeight) {
		this.rHeight = rHeight;
		return this;
	}
	
	public void updateHeights() {
		if(this.l==null)
			this.lHeight=-1;
		if(this.r==null)
			this.rHeight=-1;
		this.height = Math.max(this.lHeight, this.rHeight)+1;
		if(this.parent!=null) {
			if(this.val<=this.parent.val)
				this.parent.lHeight=this.height;
			else
				this.parent.rHeight=this.height;
				
			this.parent.updateHeights();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((l == null) ? 0 : l.hashCode());
		result = prime * result + lHeight;
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + rHeight;
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
		BinaryTreeNode other = (BinaryTreeNode) obj;
		if (height != other.height)
			return false;
		if (l == null) {
			if (other.l != null)
				return false;
		} else if (!l.equals(other.l))
			return false;
		if (lHeight != other.lHeight)
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (r == null) {
			if (other.r != null)
				return false;
		} else if (!r.equals(other.r))
			return false;
		if (rHeight != other.rHeight)
			return false;
		if (val != other.val)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("{");
			str.append("\"val\":"+val);
			if(parent!=null)
				str.append(", \"parent\":"+parent.val);
			str.append(", \"height\":"+height);
			if(l!=null)
				str.append(", \"l\":"+l);
			else
				str.append(", \"lHeight\":"+lHeight);
			if(r!=null)
				str.append(", \"r\":"+r);
			else
				str.append(", \"rHeight\":"+rHeight);
			str.append("}");
		return str.toString();
	}
	
}