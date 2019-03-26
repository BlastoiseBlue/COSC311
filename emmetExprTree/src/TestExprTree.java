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
    public static void main(String args[]) throws IOException 
    {
        ExprTree testExpression = new ExprTree( );    // Test expression
        ExprTree assignExpression = new ExprTree( );  // Test copying ExprTree
        
        System.out.println( );
        System.out.print("Enter an expression in prefix form : ");
        
        testExpression.build( );
        testExpression.showStructure( );
        testExpression.expression( );
        System.out.println(" = " + testExpression.evaluate( ));

//1     // Test the copy constructor.   (In-lab Exercise 1)
//1     System.out.println("Copy using a Copy Constructor");
//1     assignExpression = new ExprTree(testExpression);
//1     dummy(assignExpression);
//1     System.out.println("Original ExprTree is:");
//1     testExpression.showStructure();
//1                 
//1     System.out.println("\nversus Cloning");
//1     assignExpression = (ExprTree)testExpression.clone();
//1     dummy(assignExpression);
//1     System.out.println("Original ExprTree is:");
//1     testExpression.showStructure();

//2     // Test the commute operation.  (In-lab Exercise 2)
//2     testExpression.commute();
//2     System.out.println( );
//2     System.out.println("Fully commuted tree: ");
//2     testExpression.showStructure();
//2     testExpression.expression();
//2     System.out.println(" = " + testExpression.evaluate());
        
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