import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class pascalTriangle{
    //Method 1 ( T(n) = O(n^3) ) =========================================================
    public static int fact(int n){
        if(n == 0 || n == 1) return 1;
        return n * fact(n-1);
    }
    public static int findNCR(int n, int r){
        return fact(n) / (fact(r) * fact(n - r));
    }
    public static ArrayList<ArrayList<Integer>> printPattern(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                int num = findNCR(i, j < i - j ? j : i - j);
                temp.add(num);
            }
            ans.add(temp);
        }
        return ans;
    }
    //Method 2( T(n): O(n^2) memorization, space complexity = o(n^2))==================================
    public static List<List<Integer>> getMyAns(int[][] ary, int n){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                temp.add(ary[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void printPattern1(int[][] ary, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i)
                    ary[i][j] = 1;
                else
                    ary[i][j] = ary[i-1][j-1] + ary[i-1][j];
            }
        }
    }
    //Optimal Approach(time complexity = n^2 , space complexity = o(1))
    public static List<List<Integer>> printPattern2(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    int num = temp.get(temp.size()-1) * (i-j+1) / j;
                    temp.add(num);   
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<List<Integer>> ans = printPattern2(n);
        System.out.println(ans);
    }
}