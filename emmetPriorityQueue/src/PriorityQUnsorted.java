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
	public void add(T value){
		element.add(value);
//		for(int i=element.size()-1;i>0;i--){
//			if(element.get(i).compareTo(element.get(i - 1)) < 0)bubbleUp(i);
//		}
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
		T placeHolder=findMin();
		//for(int i=0;i<element.size()-1;i++)element.set(i,element.get(i+1));
//		for(int i=0;i<element.size();i++){
//			if(element.get(i).compareTo(element.get(minIndex))<0)minIndex=i;
//		}
		element.remove(minIndex());
		return placeHolder;
	}
	private int minIndex(){
		int m=0;
		for(int i=0;i<element.size();i++){
			if(element.get(i).compareTo(element.get(m))<0)m=i;
		}
		return m;
	}
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
		for (T value:element) {
			s+=(value+", ");
		}
		s=s.replaceAll(", $","");
		return s;
	}
}
