import java.util.ArrayList;

/**
 * @author Emmet Stanevich
 * Created on 4/10/19
 * This program accepts inputs of comparables, adding them to a priority queue
 */
public class PriorityQSorted <T extends Comparable<? super T>> {
	ArrayList<T> element=new ArrayList<>();
	public boolean isEmpty(){
		return element.isEmpty();
	}
	
	/**
	 * Adds a value to the queue, then sorts it
	 * @param value The value to be added to the queue
	 */
	public void add(T value){
		element.add(value);
		for(int i=element.size()-1;i>0;i--){
			if(element.get(i).compareTo(element.get(i - 1)) < 0)bubbleUp(i);
		}
	}
	
	/**
	 * Switches a value with the one immediately preceding it
	 * @param index The index of the latter value
	 */
	private void bubbleUp(int index){
		try {
			if(index==0)throw new ArrayIndexOutOfBoundsException();
			T placeHolder = element.get(index - 1);
			element.set(index - 1, element.get(index));
			element.set(index, placeHolder);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.exit(0);
		}
	}
	
	/**
	 * Alternate call to remove()
	 * @return The value removed
	 */
	public T deleteMin(){
		return remove();
	}
	
	/**
	 * Removes the smallest value from the queue
	 * @return The value removed
	 */
	public T remove(){
		T placeHolder=element.get(0);
		//for(int i=0;i<element.size()-1;i++)element.set(i,element.get(i+1));
		element.remove(0);
		return placeHolder;
	}
	
	/**
	 * Shows the smallest element in the array
	 * @return The element in the front of the array
	 */
	public T findMin(){
		return element.get(0);
	}
	public String toString(){
		String s="";
		for (T value:element) {
			s+=(value+", ");
		}
		s=s.replaceAll(", $","");
		return s;
	}
}
