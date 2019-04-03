//--------------------------------------------------------------------
//
//  Laboratory 11                                   TestExprTree.java
//
//  Test program for the operations in the Expression Tree ADT
//
//--------------------------------------------------------------------

import java.io.*;

class TestExprTree
{
    public static void main(String[] args) throws Exception
    {
        ExprTree testExpression = new ExprTree(new ExprTreeNode('+',new ExprTreeNode('1'),new ExprTreeNode('2')));    // Test expression
        ExprTree assignExpression = new ExprTree();  // Test copying ExprTree
        
        System.out.println( );
        System.out.print("Enter an expression in prefix form : ");
        
        testExpression.build( );
        testExpression.showStructure( );
        testExpression.expression( );
        System.out.println(" = " + testExpression.evaluate( ));
    
        // Test the copy constructor.   (In-lab Exercise 1)
        System.out.println("Copy using a Copy Constructor");
        assignExpression = new ExprTree(testExpression);
        dummy(assignExpression);
        System.out.println("Original ExprTree is:");
        testExpression.showStructure();
    
        System.out.println("\nVersus Cloning");
        assignExpression = (ExprTree)testExpression.clone();
        dummy(assignExpression);
        System.out.println("Original ExprTree is:");
        testExpression.showStructure();
    
        // Test the commute operation.  (In-lab Exercise 2)
        testExpression.commute();
        System.out.println( );
        System.out.println("Fully commuted tree: ");
        testExpression.showStructure();
        testExpression.expression();
        System.out.println(" = " + testExpression.evaluate());
        
        System.out.println( );
        System.out.println("Clear the tree");
        testExpression.clear( );
        testExpression.showStructure( );
    } // main

    static void dummy ( ExprTree copyTree )
    // Dummy routine that is passed an expression tree which (preferably) 
    // should not change the original expression tree.
    // Outputs copyTree and clears it.

    {
        System.out.println( );
        System.out.println("Copy of tree:  ");
        copyTree.showStructure( );
        copyTree.clear( );
        System.out.println("Copy cleared:   ");
        copyTree.showStructure( );
        System.out.println( );
    }

} // class TestExprTree