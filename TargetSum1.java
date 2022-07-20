import java.util.Scanner;
import java.util.Arrays;
public class TargetSum1{
	public static Scanner scn = new Scanner(System.in);
	public static void findTarget(int ary[],int si,int ei,int target){
		int sum = 0;
		while(sum <= target){
		    sum = ary[si] + ary[ei];
			if(sum > target){
				ei--;
			} else if(sum < target){
				si++;
			} else {
				System.out.println(ary[si] + ", " + ary[ei]);
				si++;
				ei--;
			}
		}
	}
	public static void main(String args[]){
		int n = scn.nextInt();
		int ary[] = new int[n];
		for(int i=0; i<n; i++){
			ary[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		Arrays.sort(ary);
		findTarget(ary,0,n-1,target);
	}
}