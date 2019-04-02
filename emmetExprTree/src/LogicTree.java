import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Emmet Stanevich
 * This program is a variation on ExprTree.java, except it now works with logic gates rather than numbers
 * Created on 3/27/19
 */
public class LogicTree implements Cloneable
//		extends ExprTree
{
	private LogicTreeNode root;
	LogicTree(LogicTreeNode r){
		root=r;
	}
	LogicTree(LogicTree valueTree){
		valueTree.clone();
		this.root=valueTree.root==null?null:valueTree.root.deepCopy();
	}
	public Object clone(){
		try {
			LogicTree c = (LogicTree) super.clone();
			c.root=root==null?null:root.deepCopy();
			return c;
		}catch (CloneNotSupportedException e){
			throw new InternalError("\nThis class does not implement Cloneable");
		}
	}
	
	/**
	 * Evaluates the argument stored within the tree
	 * @return The end result of the evaluation
	 */
	public boolean evaluate(){
		try {
			return evalSub(root);
		}catch(Exception e){
			return false;
		}
	}
	private boolean evalSub(LogicTreeNode n){
		if(Character.isDigit(n.getElement())){
			if(n.getElement()=='1')return true;
			else return false;
		}
		else{
			switch (n.getElement()){
				case '+':
					return (evalSub((LogicTreeNode) n.getLeft())||evalSub((LogicTreeNode) n.getRight()));
				case '-':
					return (!(evalSub((LogicTreeNode) n.getRight())));
				case '*':
					return (evalSub((LogicTreeNode) n.getLeft())&&evalSub((LogicTreeNode) n.getRight()));
			}
		}throw new Error("Cannot evaluate");
	}
	
	/**
	 * Creates a logic tree out of user input
	 * @throws IOException
	 */
	public void build ()  // Build tree from prefix expression
	{
		Scanner kbd=new Scanner(System.in);
		String input=kbd.nextLine();
		build(input);
	}
	
	/**
	 * Creates a logic tree from a supplied string
	 * @param s
	 */
	public void build (String s) {
		byte[] input=s.getBytes();
		ByteArrayInputStream buffer=new ByteArrayInputStream(input);
		try {
			buildSub(root, buffer);
		}catch(IOException e){
			System.out.println(e);
			root=null;
		}
	}
	private void buildSub(LogicTreeNode n, ByteArrayInputStream b) throws IOException {
		byte x;
		do{
			n.setElement((char) b.read());
			x=(byte)n.getElement();
			if(x==-1)throw new IOException("Too few operands!");
		}while(Character.isWhitespace(n.getElement()));
		if(Character.isDigit(n.getElement())){
			n.setLeft(null);
			n.setRight(null);
		}
		else if(n.getElement()=='-'){
			n.setLeft(null);
			n.setRight(new LogicTreeNode());
			buildSub((LogicTreeNode) n.getRight(),b);
		}
		else if(x==42||x==43){
			n.setLeft(new LogicTreeNode());
			n.setRight(new LogicTreeNode());
			buildSub((LogicTreeNode) n.getLeft(),b);
			buildSub((LogicTreeNode) n.getRight(),b);
		}else throw new IOException("Invalid input: "+n.getElement());
	}
	/**
    * Clears the tree by setting the root to null
    */
public void clear ( )   // Clear tree
{
	root=null;
}
	public void expression ( )  // Output expression in infix form
	{
		try {
			expressionSub(root);
			System.out.println();
		}catch(Exception e){
			System.out.println("Expression Error: "+e);
		}
	}
	private void expressionSub(LogicTreeNode n) throws Exception{
		if(n==null)throw new Exception("Root is null");
		if(n.getElement()=='-'&&Character.isDigit(n.getRight().getElement()))System.out.print("(");
		if(n.getLeft()!=null) {
			System.out.print("(");
			expressionSub((LogicTreeNode) n.getLeft());
		}
		System.out.print(n.getElement());
		if(n.getRight()!=null) {
			expressionSub((LogicTreeNode) n.getRight());
			System.out.print(")");
		}
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
	public void commute ( )  // Commute all subexpr.
	{
		root=root==null?null:commuteSub(root);
	}
	
	/**
	 * Generates and returns a copy of the subtree, recursively commuted
	 * @param n The root of the subtree to be commuted
	 * @return The commuted subtree
	 */
	private LogicTreeNode commuteSub(LogicTreeNode n){
		LogicTreeNode newNode=new LogicTreeNode(n.getElement(),null,null);
		if(n.getElement()=='-'){
			newNode.setRight(commuteSub((LogicTreeNode) n.getRight()));
		}else {
			if (n.getLeft() != null) newNode.setRight(commuteSub((LogicTreeNode) n.getLeft()));
			if (n.getRight() != null) newNode.setLeft(commuteSub((LogicTreeNode) n.getRight()));
		}return newNode;
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
}
