import java.util.ArrayList;

/**
 * @author Emmet Stanevich
 */
public class PriorityQofPairs <ValueType, PriorityType extends Comparable<? super PriorityType>> {
	ArrayList<Pair> pairs=new ArrayList<>();
	class Pair
			//<ValueType,PriorityType>
	{
		ValueType value;
		PriorityType priority;
		Pair(ValueType v, PriorityType p){
			value=v;
			priority=p;
		}
		Pair(Pair p){
			value=p.getValue();
			priority=p.getPriority();
		}
		ValueType getValue(){
			return value;
		}
		PriorityType getPriority(){
			return priority;
		}
	}
	public void add(ValueType v, PriorityType p){
		pairs.add(new Pair(v,p));
	}
	public int minIndex(){
		int m=0;
		for(int i=0;i<pairs.size();i++){
			if(pairs.get(i).getPriority().compareTo(pairs.get(m).getPriority())<0)m=i;
		}
		return m;
	}
	public ValueType findMin(){
		return pairs.get(minIndex()).getValue();
	}
	public ValueType deleteMin(){
		return remove();
	}
	public ValueType remove(){
		ValueType hold=findMin();
		pairs.remove(minIndex());
		return hold;
	}
	public boolean isEmpty(){
		return pairs.isEmpty();
	}
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
