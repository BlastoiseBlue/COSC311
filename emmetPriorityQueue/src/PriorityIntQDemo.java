/**
 * @author Emmet Stanevich
 */
public class PriorityIntQDemo
{
	public static void dumpPQ(String msg, PriorityIntQSorted pq)
	{
		System.out.println( msg + ":" );
		while( !pq.isEmpty( ) )
			System.out.println( pq.remove( ) + " ");
	}
	
	// Do some inserts and removes (done in dumpPQ).
	public static void main( String [ ] args )
	{
		PriorityIntQSorted minPQ = new PriorityIntQSorted( );
		
		minPQ.add( 4 );
		minPQ.add( 3 );
		minPQ.add( 5 );
		int result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ should be 3 and is "+result);
		
		minPQ.deleteMin( );
		result = minPQ.findMin();
		System.out.println("Smallest value in priorityQ should be 4 and is "+result);
		
		System.out.println( minPQ );
		dumpPQ( "minPQ", minPQ );
	}
}