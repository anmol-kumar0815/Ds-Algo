import java.util.Scanner;
public class Spanofarray{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int max = -1;
        int min = 1000000000;
        int ary[] = new int[n];
        for(int i=0; i<n; i++){
            ary[i] = scn.nextInt();
            if(ary[i] > max){
                max = ary[i];
            }
            if(ary[i] < min){
                min = ary[i];
            }
        }
        int ans = max - min;
        System.out.println(ans);
    }
}