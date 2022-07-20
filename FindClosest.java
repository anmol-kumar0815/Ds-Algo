import java.util.Scanner;
import java.lang.Math;
public class FindClosest {
	public static Scanner scn = new Scanner(System.in);

	public static int findClosestFun(int ary[],int si,int ei,int data){
		if(ary[si] >= data) return si;
		else if(ary[ei] <= data) return ei;
		while(si <= ei){
			int mid = (si + ei) / 2;
			if(ary[mid] == data){
				return mid;
			} else if(ary[mid] > data) {
				ei = mid - 1;
			} else {
				si = mid + 1;
			}
		}
		return (Math.abs(ary[si] - data) < Math.abs(ary[ei] - data) ? si : ei);
	}
	
	public static void main(String args[]){
		int n = scn.nextInt();
		int ary[] = new int[n];
		for(int i=0; i<n; i++){
			ary[i] = scn.nextInt();
		}
		int data = scn.nextInt();
		int ans = findClosestFun(ary,0,n-1,data);
		System.out.println(ans);
	}
}