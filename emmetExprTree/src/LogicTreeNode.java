/**
 * @author Emmet Stanevich
 */
public class LogicTreeNode implements TreeNode {
	private char element;
	private TreeNode left,right;
	LogicTreeNode(char elem){
		element=elem;
	}
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
	LogicTreeNode(){
		//super();
	}
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
	public LogicTreeNode deepCopy(){
		return new LogicTreeNode(getElement(),
				getLeft()==null?null:getLeft().deepCopy(),
				getRight()==null?null:getRight().deepCopy());
	}
	
}
