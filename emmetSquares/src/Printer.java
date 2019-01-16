/**
 * @author Emmet Stanevich
 * Prints out the first 50 squares and their sum and average
 */
public class Printer {
	
	private static final int NUM_SQUARES = 50;
	
	public static void main(String[] args){
		squares();
	}
	public static void squares(){
		int sum=0;
		for(int i = 1; i<= NUM_SQUARES; i++){
			sum+=(i*i);
			System.out.print(i*i);
			if(i<NUM_SQUARES)System.out.print(", ");
		}
		double average=sum/(double)NUM_SQUARES;
		System.out.println("\nSum: "+sum+"\nAverage: "+average);
	}
}
