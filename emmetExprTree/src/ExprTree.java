/**
 * @author Emmet Stanevich
 */
import sun.reflect.generics.tree.Tree;

import java.io.*;

public class ExprTree{
	// Data member
	private TreeNode root;  // Reference to the root node
	
	// Constructor
	public ExprTree (TreeNode r){
		root=r;
	}
	class ExprTreeNode implements TreeNode{
		private char element;
		private TreeNode left, right;
		ExprTreeNode(char elem, TreeNode l, TreeNode r){
			element=elem;
			left=l;
			right=r;
		}
		ExprTreeNode(char elem){
			new ExprTreeNode(elem,null,null);
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
		public TreeNode copy(){
			//TreeNode clone = (TreeNode) super.clone();
			
			return new ExprTreeNode(element,left==null?null:left.copy(),right==null?null:right.copy());
		}
	}
	// In-lab 1
	// Remove the surrounding comment markers when ready to implement
    
    public ExprTree ( ExprTree valueTree ){
		
    }
    public Object copy(){
	    //return super.clone();
	    return new ExprTree(root.copy());
    }
    
	
	// Expression tree manipulation operations
	
	/**
	 *  Get a string representing the prefix notation form of an expression from the console.
	 *  Create a expression tree representing that string.
	 **/
//	public void build ( ) throws IOException // Build tree from prefix expression
//	{}
//	public void expression ( )  // Output expression in infix form
//	{}
//	public float evaluate ( )   // Evaluate expression
//	{}
//	public void clear ( )   // Clear tree
//	{}
	
	public void showStructure ( ) {
		// Outputs an expression tree. The tree is output rotated counter-
		// clockwise 90 degrees from its conventional orientation using a
		// "reverse" inorder traversal. This operation is intended for testing
		// and debugging purposes only.
		if ( root == null )
			System.out.println("Empty tree");
		else
		{
			System.out.println( );
			showSub(root, 1);
			System.out.println( );
		}
	}
	
	// In-lab 2
	// Remove the surrounding comment markers when ready to implement
    /* public void commute ( )  // Commute all subexpr.
    {}
    */
	
	// Recursive partners of the public member methods ....
	// -- insert/complete the definition of these methods here.
	
	private void showSub ( TreeNode p, int level )
	// Recursive partner of the showStructure() method. Outputs the
	// subtree whose root node is pointed to by p. Parameter level is the
	// level of this node within the expression tree.
	{
		int j;                                      // Loop counter
		TreeNode right,
				left;
		
		if ( p != null )
		{
			// For efficiency, calculate right and left only once
			right = p.getRight( );
			left = p.getLeft( );
			
			showSub(right, level+1);                // Output right subtree
			for ( j = 0 ; j < level ; j++ )         // Tab over to level
				System.out.print("\t");
			System.out.print(" " + p.getElement( ));// Output element
			if ( ( left != null ) &&                // Output "connector"
					( right != null ) )
				System.out.print("<");
			else if ( right != null )
				System.out.print("/");
			else if ( left != null )
				System.out.print("\\");
			System.out.println( );
			showSub(left, level+1);                 // Output left subtree
		}
	}
	/**
	 *  This is a helper function for build().  You needn't use this approach in your own
	 *  implementation.
	 *  @param  prefixString  The argument initially consists of the prefix notation of an expression.
	 *      SIDE-EFFECT:the state of this param will be changed as it is used.
	 **/
//	private TreeNode buildSub ( ByteArrayInputStream prefixString )  throws IOException
//	// Recursive partner of the build() method. Builds a subtree and
//	// returns the root of the tree.
//	//
//	{}
	
	// -- Insert the definition of the rest of
	// -- the recursive partners of the public methods below.
	// -- These recursive (helper) methods will be private.
	
} // class ExprTree