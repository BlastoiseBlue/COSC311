//import java.io.ByteArrayInputStream;

/**
 * @author Emmet Stanevich
 * This program is to be used by the ExprTree class
 * Created on 3/25/19
 */
class ExprTreeNode implements TreeNode{
	private char element;
	private TreeNode left, right;
	
	/**
	 * Default constructor
	 * @param elem The data to be stored in the node
	 * @param l This node's left child
	 * @param r This node's right child
	 */
	ExprTreeNode(char elem, TreeNode l, TreeNode r){
		element=elem;
		left=l;
		right=r;
	}
	
	/**
	 * No-argument constructor, useful for buildSub
	 */
	ExprTreeNode(){
	}
	
	/**
	 * Single argument constructor, initializes children to null
	 * @param elem The piece of data to be stored
	 */
	ExprTreeNode(char elem){
		new ExprTreeNode(elem,null,null);
	}
//	public boolean isLeaf(){
//		return(left==null&&right==null);
//	}
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
	
	/**
	 * Deep copy method for nodes
	 * @return A recursively generated copy of this node, with copies of its children, their children, etc.
	 */
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