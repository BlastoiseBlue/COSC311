import java.util.Comparator;

/**
 * @author Emmet Stanevich
 * Stores an ordered collection of objects, which can have values added to and removed from it
 * Created using the textbook as reference
 */
public class OrderedCollection <AnyType extends Comparable<? super AnyType>> {
	public OrderedCollection(){
	
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
				Object [] tempMem=new Object[memory.length-1];
				int k=0;
				for(int j=0;j<memory.length;j++){
					//if()
				}
				clean();
				//memory=tempMem;
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
		int j=0;
		for(int i=0; i<size;i++){
			if(memory[j]!=null) tempMem[i]=memory[j];
			else {
				//j++;
				i--;
			}
			j++;
		}
		memory=tempMem;
	}
	public int memSize(){
		return memory.length;
	}
	Object [] memory = null;
	Comparator cmp= new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			return 0;
		}
		
		@Override
		public boolean equals(Object obj) {
			return false;
		}
	};
	public <AnyType>
	AnyType findMax(){
		if(!isEmpty()){
			int maxIndex=0;
			for(int i=0;i<memory.length;i++){
				if(cmp.compare(memory[i],memory[maxIndex])>0)maxIndex=i;
			}
			return (AnyType) memory[maxIndex];
		}
		else return null;
	}
	public <AnyType>
	AnyType findMin(){
		if(!isEmpty()){
			int minIndex=0;
			for(int i=0;i<memory.length;i++){
				if(cmp.compare(memory[i],memory[minIndex])>0)minIndex=i;
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
		x.remove(12);
		System.out.println(x.search(10));
		System.out.println(x.search(15));
		System.out.println(x.memSize());
	}
}
