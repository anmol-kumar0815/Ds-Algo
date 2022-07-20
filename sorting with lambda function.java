import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class sorthing with lambda function{
    public static void print(Integer[] ary){
        for(int ele : ary){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[] ary = new Integer[n];
        for(int i=0; i<n; i++){
            ary[i] = scn.nextInt();            
        }
        
        Arrays.sort(ary, (a,b) -> {
            return b - a;
        });

        print(ary);
    }
}