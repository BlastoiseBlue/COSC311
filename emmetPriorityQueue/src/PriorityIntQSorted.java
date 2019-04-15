/**
 * @author Emmet Stanevich
 * Created on 4/10/19
 * This program accepts inputs of ints, adding them to a priority queue
 */
public class PriorityIntQSorted {
	private int[] element;
	public boolean isEmpty(){
		return element.length==0;
	}
	public PriorityIntQSorted(){
		element=new int[0];
	}
	
	/**
	 * Switches a value with the one immediately preceding it
	 * @param index The location of the value to switch
	 */
	public void bubbleUp(int index){
		try {
			if(index==0)throw new ArrayIndexOutOfBoundsException();
			int hold = element[index - 1];
			element[index - 1] = element[index];
			element[index] = hold;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.exit(0);
		}
	}
	
	/**
	 * Adds an int into the array, then sorts it
	 * @param input The value to be inserted
	 */
	public void add(int input){
		int[] newElem= new int[element.length+1];
		for (int i = 0;i<element.length; i++) {
			newElem[i]=element[i];
		}
		element=newElem;
		element[element.length-1]=input;
		for(int j=element.length-1;j>0;j--){
			if(element[j]<element[j-1])bubbleUp(j);
		}
	}
	public String toString(){
		String s="";
		for (int value : element) {
			s+=(value + ", ");
		}
		s=s.replaceAll(", $","");
		return s;
	}
	
	/**
	 * Shows the smallest element in the array
	 * @return The element in the front of the array
	 */
	public int findMin(){
		return element[0];
	}
	
	/**
	 * Alternate call to remove()
	 * @return The value on the top of the queue
	 */
	public int deleteMin(){
		return remove();
	}
	
	/**
	 * Removes the smallest value from the queue
	 * @return The value removed
	 */
	public int remove(){
		int hold=element[0];
		int[] newElem=new int[element.length-1];
		for(int i=0;i<newElem.length;i++){
			newElem[i]=element[i+1];
		}
		element=newElem;
		return hold;
	}
}
