/**
 * @author Emmet Stanevich
 * Created on 4/10/19
 * This program accepts inputs of ints, adding them to a priority queue
 */
public class PriorityIntQSorted {
	private int[] arr;
	public boolean isEmpty(){
		return arr.length==0;
	}
	public PriorityIntQSorted(){
		arr =new int[0];
	}
	
	/**
	 * Switches a value with the one immediately preceding it
	 * @param index The location of the value to switch
	 */
	public void bubbleUp(int index){
		try {
			if(index==0)throw new ArrayIndexOutOfBoundsException();
			int hold = arr[index - 1];
			arr[index - 1] = arr[index];
			arr[index] = hold;
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
		int[] newElem= new int[arr.length+1];
		for (int i = 0; i< arr.length; i++) {
			newElem[i]= arr[i];
		}
		arr =newElem;
		arr[arr.length-1]=input;
		for(int j = arr.length-1; j>0; j--){
			if(arr[j]< arr[j-1])bubbleUp(j);
		}
	}
	public void insert(int input){
		add(input);
	}
	/**
	 * Overrides the toString() method
	 * @return A string containing the contents of the queue in the order in which they would be removed, separated by commas
	 */
	public String toString(){
		String s="";
		for (int value : arr) {
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
		return element();
	}
	
	public int element(){
		return arr[0];
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
		int hold= arr[0];
		int[] newElem=new int[arr.length-1];
		for(int i=0;i<newElem.length;i++){
			newElem[i]= arr[i+1];
		}
		arr =newElem;
		return hold;
	}
}
