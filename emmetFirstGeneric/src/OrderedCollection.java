/**
 * @author Emmet Stanevich
 */
public class OrderedCollection <AnyType extends Comparable<? super AnyType>> {
	//public static <AnyType >
	public OrderedCollection(){
		//memory=new AnyType[];
	}
	public boolean isEmpty(){
		if(memory==null)return true;
		else return false;
	}
	public void makeEmpty(){
		memory=null;
	}
	public void insert(){
		//if(isEmpty())memory=new AnyType[1];
		AnyType[] mem1=new Anytype[memory.length+1];
		for(int i=0;i<memory.length;i++)mem1[i]=memory[i];
		
	}
	public void remove(AnyType x){
	
	}
	AnyType[] memory;
	AnyType findMax(AnyType [] arr){
		if(!isEmpty()){
			//for()
		}
	}
}
