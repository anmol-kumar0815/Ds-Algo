import java.util.Scanner;
public class XOR{
	
	public static long findSum(long ary[]){
		long sum = 0;
		for(int i=0; i<ary.length; i++){
			sum += ary[i];
		}
		return sum;
	}
	
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
	    long ary[] = new long[200000];
		for(int i=0; i<n; i++){
			ary[i] = scn.nextLong();
		}
		long t = scn.nextLong();
		while(t-- > 0){
			long sum = 0;
			long sublen = scn.nextLong();
			for(int i=2; i<=sublen; i++){
				sum += getSubsequenceSum(ary,i);
			}
			sum += findSum(ary);
			System.out.println(sum);
		}
	}
}