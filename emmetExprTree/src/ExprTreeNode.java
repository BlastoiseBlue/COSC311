import java.io.ByteArrayInputStream;

/**
 * @author Emmet Stanevich
 */
class ExprTreeNode implements TreeNode{
	private char element;
	private TreeNode left, right;
	ExprTreeNode(char elem, TreeNode l, TreeNode r){
		element=elem;
		left=l;
		right=r;
	}
	ExprTreeNode(){
	}
	ExprTreeNode(char elem){
		new ExprTreeNode(elem,null,null);
	}
	public boolean isLeaf(){
		return(left==null&&right==null);
	}
	public void setElement(char elem){
		element =elem;
	}
	public char getElement(){
		return element;
	}
	public TreeNode getLeft(){
		return left;
	}
	public TreeNode getRight(){
		return right;
	}
	public TreeNode setLeft(TreeNode node){
		left=node;
		return left;
	}
	public TreeNode setRight(TreeNode node){
		right=node;
		return right;
	}
	public ExprTreeNode deepCopy(){
		return new ExprTreeNode(getElement(),
				getLeft()==null?null:getLeft().deepCopy(),
				getRight()==null?null:getRight().deepCopy());
	}
//	public void clear(){
//		left.clear();
//		left=null;
//		right.clear();
//		right=null;
//
//	}
//	public Object clone(){
//		try{
//			TreeNode c = (TreeNode) super.clone();
//			c.setLeft((TreeNode) getLeft().clone());
//			c.setRight((TreeNode) getRight().clone());
//			return c;
//		}catch(CloneNotSupportedException e){
//			throw new InternalError("\nThis class does not implement Cloneable");
//		}
//	}
}