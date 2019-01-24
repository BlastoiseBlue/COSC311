/**
 * @author Emmet Stanevich
 * Stores an ordered collection of objects, which can have values added to and removed from it
 * Created using the textbook as reference
 */
public class OrderedCollection <AnyType extends Comparable<? super AnyType>> {
	public OrderedCollection(){
	
	}
	public String toString(){
		StringBuilder output = null;
		if(!isEmpty()){
			output = new StringBuilder((String) memory[0]);
			if(memory.length>1){
				
				for(int i=1; i<memory.length;i++){
					output.append(", ").append(memory[i]);
				}
			}
		}
		assert output != null;
		return output.toString();
	}
	/**
	 * Returns the positional index of a specified object
	 * @param x the object for the function to look for
	 */
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
		return memory == null;
	}
	public void makeEmpty(){
		memory=null;
	}
	/**
	public void insert(Comparable<? super AnyType> newEntry){
		if(isEmpty()){
			memory=new Comparable[1];
			memory[0]= newEntry;
		}
		else {
			Comparable [] tempMem=new Comparable[memory.length+1];
			for(int i=0;i<memory.length;i++)tempMem[i]=memory[i];
			tempMem[memory.length]=newEntry;
			memory=tempMem;
		}
		
	}
	
	public boolean remove(AnyType target){
		for (int i=0;i<memory.length;i++){
			if(memory[i].compareTo(target)==0){
				memory[i]=null;
				clean();
				return true;
			}
		}return false;
	}
	private void clean(){
		int size=0;
		for (Comparable comparable : memory) {
			if (comparable != null) size++;
		}
		Comparable [] tempMem=new Comparable[size];
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
	private Comparable [] memory = null;
	public <AnyType extends Comparable<? super  AnyType>>
	AnyType findMax(){
		if(!isEmpty()){
			int maxIndex=0;
			for(int i=0;i<memory.length;i++){
				if(memory[i].compareTo(memory[maxIndex])>0)maxIndex=i;
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
				if(memory[i].compareTo(memory[minIndex])<0)minIndex=i;
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
