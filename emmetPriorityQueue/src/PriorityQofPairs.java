import java.util.ArrayList;

/**
 * @author Emmet Stanevich
 * Created on 4/15/19
 * This program will accept pairs of generic values, with the latter being comparable, and use the former to store a key, and the latter to store its priority in the queue.
 * This program will not sort the contents of the queue, instead working off of the framework of the PriorityQUnsorted program.
 */
public class PriorityQofPairs <ValueType, PriorityType extends Comparable<? super PriorityType>> {
	ArrayList<Pair> pairs=new ArrayList<>();
	
	/**
	 * Inner class to be used as elements in the ArrayList
	 */
	class Pair
			//<ValueType,PriorityType>
	{
		ValueType value;
		PriorityType priority;
		
		/**
		 * Standard constructor
		 * @param v The data to be stored in this pair
		 * @param p The priority of this pair, to be used
		 */
		Pair(ValueType v, PriorityType p){
			value=v;
			priority=p;
		}
		
		/**
		 * Copy constructor
		 * @param p The pair to be used as a base
		 */
		Pair(Pair p){
			value=p.getValue();
			priority=p.getPriority();
		}
		
		/**
		 *
		 * @return The value stored in this pair
		 */
		ValueType getValue(){
			return value;
		}
		
		/**
		 *
		 * @return The priority of this pair
		 */
		PriorityType getPriority(){
			return priority;
		}
	}
	
	/**
	 * Adds a new pair to the queue
	 * @param v The value of the new pair
	 * @param p The priority of the new pair
	 */
	public void add(ValueType v, PriorityType p){
		pairs.add(new Pair(v,p));
	}
	
	/**
	 * Searches the queue, updating an internal value whenever it finds a pair with a smaller priority than the current smallest one.
	 * @return The location of the pair with the smallest priority
	 */
	public int minIndex(){
		int m=0;
		for(int i=0;i<pairs.size();i++){
			if(pairs.get(i).getPriority().compareTo(pairs.get(m).getPriority())<0)m=i;
		}
		return m;
	}
	
	/**
	 * Searches the queue by calling minIndex(), and then returns the value of the pair with the smallest priority.
	 * @return The value of the pair with the smallest priority
	 */
	public ValueType findMin(){
		return pairs.get(minIndex()).getValue();
	}
	
	/**
	 * Alternate call to remove()
	 * @return The value of the pair that just got removed
	 */
	public ValueType deleteMin(){
		return remove();
	}
	
	/**
	 * Removes the pair with the smallest priority
	 * @return The value of the pair that just got removed
	 */
	public ValueType remove(){
		ValueType hold=findMin();
		pairs.remove(minIndex());
		return hold;
	}
	
	/**
	 * Returns true if the ArrayList is empty, returns false otherwise
	 * @return Whether the ArrayList is empty
	 */
	public boolean isEmpty(){
		return pairs.isEmpty();
	}
	
	/**
	 * Overrides the toString() method
	 * @return A string containing the contents of the queue in the order in which they would be removed, separated by commas
	 */
	public String toString(){
		ArrayList<Pair> hold=new ArrayList<>();
		for (Pair element:
		     pairs) {
			hold.add(new Pair(element));
		}
		String s="";
		while(!pairs.isEmpty())s+=remove()+", ";
		s=s.replaceAll(", $","");
		pairs=hold;
		return s;
	}
}
