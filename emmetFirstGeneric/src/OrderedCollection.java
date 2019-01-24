import java.util.Comparator;

/**
 * @author Emmet Stanevich
 * Stores an ordered collection of objects, which can have values added to and removed from it
 * Created using the textbook as reference
 */
class CaseInsensitiveCompare implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
}
public class OrderedCollection <AnyType extends Comparable<? super AnyType>> {
	public OrderedCollection(){
	
	}
	public String toString(){
		String output = null;
		if(!isEmpty()){
			output= (String) memory[0];
			if(memory.length>1){
				
				for(int i=1; i<memory.length;i++){
					output+=", "+(String) memory[i];
				}
			}
		}
		return output;
	}
	private int search(Comparable<? super AnyType> x){
		if(!isEmpty()){
			int pos=-1;
			for(int i=0;i<memory.length;i++){
				if(memory[i]==x)return i;
			}
			return -1;
		}
		else return -1;
	}
	public boolean isEmpty(){
		if(memory==null)return true;
		else return false;
	}
	public void makeEmpty(){
		memory=null;
	}
	public void insert(Comparable<? super AnyType> x){
		if(isEmpty()){
			memory=new Object[1];
			memory[0]= (AnyType) x;
		}
		else {
			Object [] tempMem=new Object[memory.length+1];
			for(int i=0;i<memory.length;i++)tempMem[i]=memory[i];
			tempMem[memory.length]=x;
			memory=tempMem;
		}
		
	}
	public boolean remove(AnyType x){
		for (int i=0;i<memory.length;i++){
			if(memory[i]==x){
				memory[i]=null;
				clean();
				return true;
			}
		}return false;
	}
	private void clean(){
		int size=0;
		for(int i=0; i<memory.length;i++){
			if(memory[i]!=null)size++;
		}
		Object [] tempMem=new Object[size];
		int memIndex=0;
		for(int tempMemIndex=0; tempMemIndex<size;tempMemIndex++){
			if(memory[memIndex]!=null) tempMem[tempMemIndex]=memory[memIndex];
			else tempMemIndex--;
			memIndex++;
		}
		memory=tempMem;
	}
	public int memSize(){
		return memory.length;
	}
	private Object [] memory = null;
	public static <AnyType extends Comparable<? super AnyType>>
	int compare(AnyType lhs, AnyType rhs){
		return lhs.compareTo(rhs);
	}
	public static //<String>
	int compare(String lhs, String rhs){
		return (int) new CaseInsensitiveCompare().compare(lhs,rhs);
	}
	public <AnyType extends Comparable<? super  AnyType>>
	AnyType findMax(){
		if(!isEmpty()){
			int maxIndex=0;
			for(int i=0;i<memory.length;i++){
				if(OrderedCollection.<AnyType>compare(memory[i],memory[maxIndex])>0)maxIndex=i;
			}
			return (AnyType) memory[maxIndex];
		}
		else return null;
	}
	
	public <AnyType extends Comparable<? super AnyType>>
	AnyType findMin(){
		if(!isEmpty()){
			int minIndex=0;
			for(int i=0;i<memory.length;i++){
				if(cmp.compare(memory[i],memory[minIndex])>0)minIndex=i;
//				memory[i]
			}
			return (AnyType) memory[minIndex];
		}
		else return null;
	}
	public static void main(String[] args){
		OrderedCollection<Integer> x = new OrderedCollection<>();
		System.out.println(x.isEmpty());
		x.insert(10);
		x.insert(12);
		x.insert(15);
		System.out.println(x.isEmpty());
		System.out.println(x.search(10));
		System.out.println(x.search(12));
		System.out.println(x.memSize());
		System.out.println(x.remove(12));
		System.out.println(x.search(10));
		System.out.println(x.search(15));
		System.out.println(x.memSize());
		System.out.println((String) x.findMax());
		System.out.println((String) x.findMin());
		x.makeEmpty();
		System.out.println(x.isEmpty());
	}
}
