/*
 * This program solves project euler 50, which prime below 1000000 can be made as the sum of the most primes
 * Micah Harkins
 */ 
public class PrimeSum {
	public static boolean[] primes; 
	public static int maxLength=0; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		genPrimes();
		int max=0; 
		for(int i=2; i<10000; i++) {
			int sum=genSum(i);
			if(sum>max) {
				System.out.println(sum);
				max=sum; 
			}
		}
	}
	/*
	 * Takes as an argument the first prime to include in the sume (2, 3, 5 etc) and adds consecutive primes
	 * returns highest prime value possible with this starting prime, but only if the length of the series
	 * is greater than the current longest series. 
	 */
	public static int genSum(int firstPrime) {
		int sum=0;
		int length=0; 
		int index=firstPrime; 
		while(sum<1000000) {
			if(primes[index]) {
				sum+=index;
				length++; 
				if(sum>1000000) {
					sum-=index; 
					break; 
				}
			}
			index++; 
		}
		if(length<maxLength||!primes[sum]) {
			return -1; 
		}
		else {
			maxLength=length; 
			return sum; 
		}
	}
	// This method creates a boolean array where the value at an index shows if that index is prime.
	public static void genPrimes() {
		primes=new boolean[2000000];
		primes[0]=false;
		primes[1]=false; 
		primes[2]=true; 
		for(int a=2; a<2000000; a++) {
			primes[a]=true; //First treat every number as prime, then eliminate multiples in the next loop
		}
		for(int i=2; i<2000000; i++) {
			if(primes[i]) {
				for(int j=2; j*i<2000000; j++) {
					primes[j*i]=false; 
				}
			}
		}
	}
}
