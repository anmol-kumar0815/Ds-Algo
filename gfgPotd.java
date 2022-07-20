import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
public class gfgPotd{


    public static void printAry(int[] ary){
        for(int i=0; i<ary.length; i++){
            System.out.print(ary[i] + " ");
        }
        System.out.println();
    }
    
    public static int findLargestSmallerInPQ(TreeSet<Integer> set, int num){

        Iterator it = set.descendingIterator();
        
        while(it.hasNext()){
            int n = (int) it.next();
            if(n < num){
                return n;
            }
        }

        return -1;
    }

    public static int[] largestSmallerAtLeft(int[] ary){
        int n = ary.length;
        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[n];
        // ans[0] = -1;

        for(int i=0; i<n; i++){
            ans[i] = findLargestSmallerInPQ(set, ary[i]);
            set.add(ary[i]);
        }

        return ans;
    }
    // public static ArrayList<Integer> maxProductSubsequence (int arr[], int n){

    // }

    public static void main(String[] args) {
        int[] ary = {6, 7, 8, 1, 2, 3, 9, 10};
        int[] ans = largestSmallerAtLeft(ary);
        printAry(ans);

    }
}