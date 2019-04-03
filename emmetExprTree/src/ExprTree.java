import java.io.*;
import java.util.Scanner;
/**
 * @author Emmet Stanevich
 * This program will be used to build an expression tree using a string, a node, or an extsitng expression tree
 * Created on 3/25/19
 */

public class ExprTree implements Cloneable{
	// Data member
	private TreeNode root;  // Reference to the root node
	
	// Constructor
	
	/**
	 * Constructor for ExprTree using a predefined node
	 * @param r The node to use for the root
	 */
	public ExprTree (ExprTreeNode r){
		root=r;
	}
	
	/**
	 * Constructor for ExprTree using a string
	 * @param s
	 */
	public ExprTree(String s) throws IOException{
		root=new ExprTreeNode();
		build(s);
	}
	
	// In-lab 1
	// Remove the surrounding comment markers when ready to implement
	
	/**
	 * Copy constructor for ExprTree
	 * @param valueTree The tree to be copied
	 */
	public ExprTree ( ExprTree valueTree ) throws Exception {
		valueTree.clone();
//		this.root=valueTree.root==null?null:valueTree.root.deepCopy();
		if(valueTree.root==null)throw new Exception("Error: Empty Tree");
		else this.root=valueTree.root.deepCopy();
    }
	
	public ExprTree() {
		root=new ExprTreeNode();
	}
	
	/**
	 * Clones the tree
	 * @return The new copy of the tree
	 */
	public Object clone(){
		try {
			ExprTree c = (ExprTree) super.clone();
			c.root=root==null?null:root.deepCopy();
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
		String input=kbd.nextLine();
		build(input);
	}
	
	/**
	 * Builds an ExprTree from a string, usually hardcoded
	 * @param s The string to be converted into an expression tree
	 */
	public void build (String s) throws IOException{
		byte[] input=s.getBytes();
		ByteArrayInputStream buffer=new ByteArrayInputStream(input);
//		try {
			buildSub(root, buffer);
//		}catch(IOException e){
//			System.out.println(e);
//			root=null;
//		}
	}
	
	/**
	 * Helper function fpr build()
	 * @param n The root of the subtree
	 * @param b The buffer to be read from
	 */
	private void buildSub(TreeNode n, ByteArrayInputStream b) throws IOException{
		byte x;
		do{
			n.setElement((char) b.read());
			x=(byte)(n.getElement());
			if(x==-1)throw new IOException("Too few operands!");
			
		}while(Character.isWhitespace(n.getElement()));
		if(Character.isDigit(n.getElement())){
			n.setLeft(null);
			n.setRight(null);
		}
		else if(x==42||x==43||x==45||x==47){
			n.setLeft(new ExprTreeNode());
			n.setRight(new ExprTreeNode());
			buildSub(n.getLeft(),b);
			buildSub(n.getRight(),b);
			if(x==47&&n.getRight().getElement()=='0')throw new IOException("Divide by Zero");
		}else throw new IOException("Invalid input: "+n.getElement());
	}
	public void expression ( ) throws Exception // Output expression in infix form
	{
//		try {
			expressionSub((ExprTreeNode) root);
			System.out.println();
//		}catch (Exception e){
//			System.out.println("Expression Error: "+e);
//		}
	}
	private void expressionSub(ExprTreeNode n) throws Exception{
		if(n==null)throw new Exception("Root is null");
		if(n.getLeft()!=null) {
			System.out.print("(");
			expressionSub((ExprTreeNode)n.getLeft());
		}
		System.out.print(n.getElement());
		if(n.getRight()!=null) {
			expressionSub((ExprTreeNode)n.getRight());
			System.out.print(")");
		}
	}
	
	/**
	 * Travels through the expression tree, evaluating it
	 * @return The result of the evaluation
	 */
	public String evaluate ( ) throws Exception  // Evaluate expression
	{
//		try {
			return String.valueOf(evalSub((ExprTreeNode) root));
//		}catch(Exception e){
//			return String.valueOf(e);
//		}
	}
	
	/**
	 * Recursively evaluates a subtree
	 * @param n The root of the subtree to be evaluated
	 * @return The evaluation of the subtree
	 */
	private float evalSub(ExprTreeNode n) throws Exception{
		if(Character.isDigit(n.getElement()))return (((float)(n.getElement())-48));
		else{
			switch (n.getElement()){
				case '+':
					return (evalSub((ExprTreeNode) n.getLeft())+evalSub((ExprTreeNode) n.getRight()));
				case '-':
					return (evalSub((ExprTreeNode)n.getLeft())-evalSub((ExprTreeNode)n.getRight()));
				case '*':
					return (evalSub((ExprTreeNode)n.getLeft())*evalSub((ExprTreeNode)n.getRight()));
				case '/':
					if(evalSub((ExprTreeNode) n.getRight())==0)throw new Exception("Divide by Zero");
					else
						return (evalSub((ExprTreeNode)n.getLeft())/evalSub((ExprTreeNode)n.getRight()));
			}
		}throw new Exception("Cannot evaluate");
	}
	
	/**
	 * Clears the tree by setting the root to null
	 */
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
     public void commute ( ) throws Exception // Commute all subexpr.
    {
//    	root=root==null?null:commuteSub((ExprTreeNode) root);
    	if(root==null)throw new Exception("Error: Empty Tree");
    	else root=commuteSub((ExprTreeNode)root);
    }
	
	/**
	 * Generates and returns a copy of the subtree, recursively commuted
	 * @param n The root of the subtree to be commuted
	 * @return The commuted subtree
	 */
	private ExprTreeNode commuteSub(ExprTreeNode n){
		ExprTreeNode newNode=new ExprTreeNode(n.getElement(),null,null);
		if(n.getLeft()!=null)newNode.setRight(commuteSub((ExprTreeNode) n.getLeft()));
		if(n.getRight()!=null)newNode.setLeft(commuteSub((ExprTreeNode)n.getRight()));
		return newNode;
	}
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
	
	// -- Insert the definition of the rest of
	// -- the recursive partners of the public methods below.
	// -- These recursive (helper) methods will be private.
	
} // class ExprTree