/**
 * @author Emmet Stanevich
 * Created on 2/18/29
 * This program will output times for each "fragment"
 * ...and so begins my torment
 */
public class MyTimings {
	public static void main(String[] args){
		final int scale=100;
		long[] myNs={100,200,400,800,1600,3200};
		System.out.println("Fragment 1:");
		for (int i = 0; i < myNs.length; i++) {
			long startTime = System.nanoTime();
			for (int j = 0; j < scale; j++) {
				fragment1(myNs[i]);
			}
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			System.out.println("Runtime for n=" + myNs[i] + " was " + runTime / scale + " nanoSeconds");
		}
		System.out.println("Fragment 3:");
		for (int i = 0; i < myNs.length; i++) {
			long startTime = System.nanoTime();
			for (int j = 0; j < scale; j++) {
				fragment3(myNs[i]);
			}
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			System.out.println("Runtime for n=" + myNs[i] + " was " + runTime / scale + " nanoSeconds");
		}
		System.out.println("Fragment 5:");
		for (int i = 0; i < myNs.length; i++) {
			long startTime = System.nanoTime();
			for (int j = 0; j < scale; j++) {
				fragment5(myNs[i]);
			}
			long endTime = System.nanoTime();
			long runTime = endTime - startTime;
			System.out.println("Runtime for n=" + myNs[i] + " was " + runTime / scale + " nanoSeconds");
		}
		System.out.println("Fragment 6:");
		for (int i = 0; i < myNs.length; i++) {
			long startTime = System.nanoTime();
			for (int j = 0; j < scale; j++) {
				fragment6(myNs[i]);
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
