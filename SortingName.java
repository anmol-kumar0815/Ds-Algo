import java.util.Scanner;
public class SortingName{

    public static String[] getMyAns(String[] ary, int n){
        for(int i=0; i<n-1; i++){
		    int ci = i;
		    for(int j=i+1; j<n; j++){
                if(ary[ci].compareToIgnoreCase(ary[j]) > 0)
                    ci = j;
            }      
		    String temp = ary[ci];
		    ary[ci] = ary[i];
		    ary[i] = temp;
	    }
        return ary;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = scn.nextInt();
        String[] ary = new String[n];
        for(int i=0; i<n; i++){
            ary[i] = scn.next();
        }
        String ans[] = getMyAns(ary,n);
        System.out.println();
        System.out.println("Sorted array is: ");
        System.out.println();
        for(int i=0; i<n; i++){
            System.out.println(ans[i]);
        }
    }
}