/**
 * @author Matt Evett
 * Modified by Emmet Stanevich
 * @version 1.1
 */
public interface TreeNode
{
	/**
	 * Sets the element of the node
	 * @param element The data value of the node
	 */
	void setElement(char element);
	
	/**
	 * @return The data value of the node
	 */
	char getElement();
	
	/**
	 * @return a reference to the root node of the left tree.  May be null.
	 */
	TreeNode getLeft();
	
	/**
	 * @return a reference to the root node of the right tree.  May be null.
	 */
	TreeNode getRight();
	
	/**
	 * Sets the left subtree to be that rooted by the given node
	 * @param node  The new root of the left subtree
	 * @return The root of the left subtree
	 */
	TreeNode setLeft(TreeNode node);
	
	/**
	 * Sets the right subtree to be that rooted by the given node
	 * @param node  The new root of the right subtree
	 * @return The root of the right subtree
	 */
	TreeNode setRight(TreeNode node);
	
	/**
	 * Makes a copy of this node and its children recursively
	 * @return A deep copy of this node
	 */
	TreeNode deepCopy();
}