
public class driverFirstGeneric {

	public static void main(String[] args) {
		OrderedCollection<String> collStr = new OrderedCollection<>();
		OrderedCollection<Integer> collInt = new OrderedCollection<>();

		System.out.println("First we'll try a collection of Strings");
		System.out.println("Initial container is empty? "+collStr.isEmpty());
		collStr.insert("Matt");
		collStr.insert("Cindy");
		collStr.insert("Rey");
		collStr.insert("Darth");
		System.out.println("isEmpty() after inserting should be false and is "+collStr.isEmpty());
		System.out.println("Smallest should be Cindy and is: "+collStr.findMin());
		System.out.println("Largest should be Rey and is: "+collStr.findMax());
		System.out.println("Attempting to remove 'Ray' should return false and returns: "+collStr.remove("Ray"));
		System.out.println("Attempting to remove 'Rey' should return true and returns: "+collStr.remove("Rey"));
		System.out.println("Largest should now be Matt and is: "+collStr.findMax());
		collStr.makeEmpty();
		System.out.println("After invoking makeEmpty, isEmpty now returns: "+collStr.isEmpty());

		System.out.println("\nLastly we'll try a collection of Integers");
		System.out.println("Initial container is empty? "+collInt.isEmpty());
		collInt.insert(332);
		collInt.insert(145);
		collInt.insert(511);
		collInt.insert(187);
		System.out.println("isEmpty() after inserting should be false and is "+collInt.isEmpty());
		System.out.println("Smallest should be 145 and is: "+collInt.findMin());
		System.out.println("Largest should be 511 and is: "+collInt.findMax());
		System.out.println("Attempting to remove 500 should return false and returns: "+collInt.remove(500));
		System.out.println("Attempting to remove 511 should return true and returns: "+collInt.remove(511));
		System.out.println("Largest should now be 332 and is: "+collInt.findMax());
		collInt.makeEmpty();
		System.out.println("After invoking makeEmpty, isEmpty now returns: "+collInt.isEmpty());
	}

}
