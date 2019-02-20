/**
 * @author Emmet Stanevich
 * Created on 2/19/19
 * This program will check a long input and determine whether or not it is a prime number
 */
public class PrimeCheck {
	private static long startTime;
	private static long endTime;
	private static long runTime;
	public static void main (String[] args){
//		int x=2;
//		double startTime;
//		start();
		System.out.println(isPrime(31));
		System.out.println(isPrime((long)(Math.pow(2,20)-1)));
		System.out.println(isPrime((long)(Math.pow(2,40)-1)));
//		System.out.println(Math.pow(2,40)-1);
//		System.out.println((long)(Math.pow(2,40)+1));
	}
	
	/**
	 *
	 * @param input The number to be checked
	 * @return Whether or not the input is no less than 2, and there are no integers between the bounds of 2 and the input's square root, inclusive, that divide evenly into the input
	 */
	private static boolean isPrime(long input){
		start();
		if(input<2){//2 is the smallest prime number, nothing less than 2 can be prime
			end();
			return false;
		}
		for(long i=2;i<=input/3;i++){//This is the highest you need to check to find any divisors. i starts at 2, since being divisible by 1 is a given, and 0 could cause problems
			if(i*i>input)break;//Ends the loop once i exceeds the input's sqrt, if it has one, and proceeds to return true
			if(input%i==0){
				end();
				System.out.println(input+" is divisible by "+i);//States which number disqualified it, useful when checking very large numbers
				return false;
			}
		}
		end();
		return true;//Returns true if none of the previous flags were triggered.
	}
	
	/**
	 * Simply records the time that this is called, could probably have been replaced with the internal function
	 */
	private static void start(){
		startTime=System.nanoTime();
	}
	
	/**
	 * Records how long the process took in nanoseconds
	 */
	private static void end(){
		endTime=System.nanoTime();
		runTime=endTime-startTime;
		System.out.println("Time taken: "+runTime+" nanoseconds");
	}
}
