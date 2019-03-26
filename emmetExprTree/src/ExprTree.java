/**
 * @author Emmet Stanevich
 */
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ExprTree implements Cloneable{
	// Data member
	private TreeNode root;  // Reference to the root node
	
	// Constructor
	public ExprTree (TreeNode r){
		root=r;
	}
	public ExprTree(String s){
		root=new ExprTreeNode();
		build(s);
	}
	
	// In-lab 1
	// Remove the surrounding comment markers when ready to implement
    
    public ExprTree ( ExprTree valueTree ){
		new ExprTree(valueTree.root.deepCopy());
    }
	
	/**
	 * Clones the tree
	 * @return The new copy of the tree
	 */
	public Object clone(){
		try {
			ExprTree c = (ExprTree) super.clone();
			c.root=root.deepCopy();
			return c;
		}catch (CloneNotSupportedException e){
			throw new InternalError("\nThis class does not implement Cloneable");
		}
    }
    
	
	// Expression tree manipulation operations
	
	/**
	 *  Get a string representing the prefix notation form of an expression from the console.
	 *  Create a expression tree representing that string.
	 **/
	public void build () throws IOException // Build tree from prefix expression
	{
		Scanner kbd=new Scanner(System.in);
		byte[] input=kbd.nextLine().getBytes();
		ByteArrayInputStream buffer=new ByteArrayInputStream(input);
		buildSub(root,buffer);
	}
	public void build (String s){
		byte[] input=s.getBytes();
		ByteArrayInputStream buffer=new ByteArrayInputStream(input);
		buildSub(root,buffer);
	}
	public void buildSub(TreeNode n, ByteArrayInputStream b){
		n.setElement((char) b.read());
		if(Character.isDigit(n.getElement())){
			n.setLeft(null);
			n.setRight(null);
		}
		else{
			n.setLeft(new ExprTreeNode());
			n.setRight(new ExprTreeNode());
			buildSub(n.getLeft(),b);
			buildSub(n.getRight(),b);
		}
	}
//	public void expression ( )  // Output expression in infix form
//	{}
//	public float evaluate ( )   // Evaluate expression
//	{}
	public void clear ( )   // Clear tree
	{
		root=null;
	}
	
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