/**
 * @author Emmet Stanevich
 * This program will output times for each "fragment"
 * ...and so it begins
 */
public class MyTimings {
	public static void main(String[] args){
		final int scale=1000;
		long[] myNs={10000,20000,40000,80000,160000,320000};
		for (int i = 0; i < myNs.length; i++) {
			long startTime = System.nanoTime();
			for (int j = 0; j < scale; j++) {
				fragment1(myNs[i]);
			}
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			System.out.println("Runtime for n=" + myNs[i] + " was " + runTime / scale + " nanoSeconds");
		}
	}
	public static void fragment1(long n){
		long sum=0;
		for(int i=0; i<n; i++){
			sum++;
		}
	}
	public static void fragment2(long n){
		long sum=0;
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				sum++;
			}
		}
	}
	public static void fragment3(long n){
		long sum=0;
		for(int i=0; i<n;i++){
			for(int j=0; j<n*n;j++){
				sum++;
			}
		}
	}
	public static void fragment4(long n){
		long sum=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<i; j++){
				sum++;
			}
		}
	}
	public static void fragment5(long n){
		long sum=0;
		for(int i=0; i<n; i++){
			for(int j=0;j<i*i;j++){
				for(int k=0;k<j;k++){
					sum++;
				}
			}
		}
	}
	public static void fragment6(long n){
		long sum=0;
		for(int i=1; i<n; i++){
			for(int j=1;j<i*i;j++){
				if(j%i==0){
					for(int k=0; k<j; k++){
						sum++;
					}
				}
			}
		}
	}
}
