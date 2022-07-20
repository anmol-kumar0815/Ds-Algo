import java.io.*;
import java.util.*;

class frogSort {
    private static final Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[]  weight = new int[n];
            int[]  len = new int[n];
			for(int i=0; i<n; i++){
                weight[i]= sc.nextInt();
                // System.out.print(weight[i]+" ");
            }
            // System.out.println(" ");
			for(int i=0; i<n; i++){
                len[i]= sc.nextInt();
                // System.out.print(len[i]+" ");
            }
            // System.out.println(" ");
			
            problem(weight,len,n);
			
        }
        
    }
    public static void  problem(int[] w, int[] l, int size) {
       int[] sortedW= new int[size];
       int[] post = new int[size];
       
       int counter =0;
          for(int j=0; j<size; j++){
           post[j]=j;
       }
       for(int i=0; i<size; i++){
           sortedW[i] = w[i];
          
       }
    
       Arrays.sort(sortedW);
        for(int j=1; j<size; j++){
            int idx = getIndexVal(w,sortedW[j]);
            int p = post[getIndexVal(w,sortedW[j-1])];
            int curr = idx;
            while(curr<=p){
                curr += l[idx];
                post[idx] =curr;
                counter++;
            }
        }
       System.out.println(counter);
      
    }
    public static int getIndexVal(int[] weight, int sortValue){
       int val =0;
        for(int i=0; i<weight.length; i++){
          if(weight[i] ==sortValue){
             val = i;
          } 
       }
    //    System.out.println(val);
       return val;
    }
    }