/**
 * @author Emmet Stanevich
 */
public class PriorityQDemo
{
	public static <AnyType extends Comparable<? super AnyType>>
	void dumpPQ(String msg, PriorityQSorted<AnyType> pq)
	{
		System.out.println( msg + ":" );
		while( !pq.isEmpty( ) )
			System.out.println( pq.remove( ) );
	}

	// Do some inserts and removes (done in dumpPQ).
	public static void main( String [ ] args )
	{
		PriorityQSorted<Integer> minPQ = new PriorityQSorted<Integer>( );

		minPQ.add( 4 );
		minPQ.add( 3 );
		minPQ.add( 5 );

		Integer result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ<> should be 3 and is "+result);

		minPQ.deleteMin( );
		result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ<> should be 4 and is "+result);

		System.out.println( minPQ );
		dumpPQ( "minPQ", minPQ );

		PriorityQSorted<String> minPQStr = new PriorityQSorted<String>( );

		minPQStr.add( "four" );
		minPQStr.add( "three" );
		minPQStr.add( "five" );

		String myResult = minPQStr.findMin();
		System.out.println("Smallest value in priorityQ<> should be five and is "+myResult);

		minPQStr.deleteMin( );
		myResult = minPQStr.findMin();
		System.out.println("Smallest value in priorityQ<> should be four and is "+myResult);

		System.out.println( minPQStr );
		dumpPQ( "minPQ", minPQStr );

	}
}