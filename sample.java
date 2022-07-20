import java.util.Scanner;
public class sample{
    public static boolean fun(int n){
        if(n == 4) return true;
        else return false;
        boolean ans = n==2 && fun(n-1);
        return ans;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        fun(5);
    }
}