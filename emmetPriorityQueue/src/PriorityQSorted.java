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
	public void add(T value){
		element.add(value);
		for(int i=element.size()-1;i>0;i--){
			if(element.get(i).compareTo(element.get(i - 1)) < 0)bubbleUp(i);
		}
	}
	private void bubbleUp(int i){
		T placeHolder=element.get(i-1);
		element.set(i-1,element.get(i));
		element.set(i,placeHolder);
	}
	public T deleteMin(){
		return remove();
	}
	public T remove(){
		T placeHolder=element.get(0);
		//for(int i=0;i<element.size()-1;i++)element.set(i,element.get(i+1));
		element.remove(0);
		return placeHolder;
	}
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
