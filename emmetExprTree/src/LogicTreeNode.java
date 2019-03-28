/**
 * @author Emmet Stanevich
 * This class is to be used by the LogicTree class
 * Created on 3/27/19
 */
public class LogicTreeNode implements TreeNode {
	private char element;
	private TreeNode left,right;
	LogicTreeNode(char elem){
		element=elem;
	}
	
	/**
	 * Default constructor
	 * @param elem The data to be stored in the node
	 * @param l The node's left child
	 * @param r The node's right child
	 */
	LogicTreeNode(char elem, TreeNode l, TreeNode r){
		element= elem;
		left=l;
		right=r;
	}
	LogicTreeNode(byte elem){
		new LogicTreeNode((byte) elem);
	}
	LogicTreeNode(byte elem,TreeNode l, TreeNode r){
		new LogicTreeNode(elem,l,r);
	}
	
	/**
	 * No-argument constructor, useful for buildSub
	 */
	LogicTreeNode(){
	}
	
	/**
	 * Sets the element of an existing node
	 * @param elem The new data to store in this node
	 */
	public void setElement(char elem){
		element =elem;
	}
	
	public void setElement(byte elem) {
		setElement((char) elem);
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
	public LogicTreeNode deepCopy(){
		return new LogicTreeNode(getElement(),
				getLeft()==null?null:getLeft().deepCopy(),
				getRight()==null?null:getRight().deepCopy());
	}
	
}
