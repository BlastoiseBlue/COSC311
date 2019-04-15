/**
 * @author Emmet Stanevich
 */
public class PriorityQofPairsDemo {
	public static <KeyType, ValueType extends Comparable<? super ValueType>>
	void dumpPQ(String msg, PriorityQofPairs<KeyType, ValueType> pq)
	{
		System.out.println( msg + ":" );
		while( !pq.isEmpty( ) )
			System.out.println( pq.remove( ) );
	}
	
	// Do some inserts and removes (done in dumpPQ).
	public static void main( String [ ] args )
	{
		PriorityQofPairs<String,Integer> minPQ = new PriorityQofPairs<>( );
		
		minPQ.add( "Number of bases", 4 );
		minPQ.add( "Threesome", 3 );
		minPQ.add( "Fifth wheel", 5 );
		
		String result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ<> should be Threesome and is "+result);
		
		minPQ.deleteMin( );
		result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ<> should be Number of Bases and is "+result);
		
		System.out.println( minPQ );
		dumpPQ( "minPQ", minPQ );
		
		
		
	}
}

