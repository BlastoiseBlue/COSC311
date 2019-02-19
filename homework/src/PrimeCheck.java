/**
 * @author Emmet Stanevich
 */
public class PrimeCheck {
	private static long startTime;
	private static long endTime;
	private static long runTime;
	public static void main (String[] args){
//		int x=2;
//		double startTime;
//		start();
		System.out.println(isPrime(2));
		System.out.println(isPrime((long)(Math.pow(2,20)-1)));
		System.out.println(isPrime((long)(Math.pow(2,40)-1)));
//		System.out.println(Math.pow(2,40)-1);
//		System.out.println((long)(Math.pow(2,40)+1));
	}
	private static boolean isPrime(long input){
		start();
		if(input<2){
			end();
			return false;
		}
		for(long i=2;i<=input/3;i++){
			if(input%i==0||i*i>=input){
				end();
				System.out.println(input+" is divisible by "+i);
				return false;
			}
		}
		end();
		return true;
	}
	private static void start(){
		startTime=System.nanoTime();
		
	}
	private static void end(){
		endTime=System.nanoTime();
		runTime=endTime-startTime;
		System.out.println("Time taken: "+runTime+" nanoseconds");
	}
}
