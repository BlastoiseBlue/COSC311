import java.util.ArrayList;

/**
 * @author Emmet Stanevich
 * Created on 4/10/19
 * This program will accept comparables and can, without sorting them, find and remove the smallest one
 */
public class PriorityQUnsorted <T extends Comparable<? super T>>{
	ArrayList<T> element=new ArrayList<>();
	public boolean isEmpty(){
		return element.isEmpty();
	}
	
	/**
	 * Adds a value to the queue, but doesn't sort it
	 * @param value The value to be added
	 */
	public void add(T value){
		element.add(value);
//		for(int i=element.size()-1;i>0;i--){
//			if(element.get(i).compareTo(element.get(i - 1)) < 0)bubbleUp(i);
//		}
	}
	
	/**
	 * Switches a value with the one immediately preceding it, this function is vestigial
	 * @param index The location of the value in the ArrayList
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
	 * @return The value removed from the queue
	 */
	public T deleteMin(){
		return remove();
	}
	
	/**
	 * Removes the smallest value from the queue
	 * @return The value removed
	 */
	public T remove(){
		T placeHolder=findMin();
		//for(int i=0;i<element.size()-1;i++)element.set(i,element.get(i+1));
//		for(int i=0;i<element.size();i++){
//			if(element.get(i).compareTo(element.get(minIndex))<0)minIndex=i;
//		}
		element.remove(minIndex());
		return placeHolder;
	}
	
	/**
	 * Searches through the queue for the location of the smallest value
	 * @return The index of the smallest value in the queue
	 */
	private int minIndex(){
		int m=0;
		for(int i=0;i<element.size();i++){
			if(element.get(i).compareTo(element.get(m))<0)m=i;
		}
		return m;
	}
	
	/**
	 * Displays the value in the location pointed at by minIndex()
	 * @return The smallest value in the queue
	 */
	public T findMin(){
//		return element.get(0);
//		int minIndex=0;
//		for(int i=0;i<element.size();i++){
//			if(element.get(i).compareTo(element.get(minIndex))<0)minIndex=i;
//		}
		return element.get(minIndex());
	}
	public String toString(){
		String s="";
		ArrayList<T> hold=new ArrayList<>();
		for (T value:element
		     ) {
			hold.add(value);
		}
		while(!element.isEmpty())s+=remove()+", ";
		s=s.replaceAll(", $","");
		element=hold;
		return s;
	}
}
