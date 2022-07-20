import java.util.Scanner;
import java.lang.Math;
public class InverseNumber {
    public static Scanner scn = new Scanner(System.in);
    public static int getMyNumber(int num) {
        int ans = 0;
        int p = 1;
        int i = 0;
        while (num > 0) {
                int rem = num % 10;
                num /= 10;
                ans = p * (int)Math.pow(10,rem-1) + ans;
                p++;
            }
        return ans;    
    }
        public static void main(String args[]) {
            int num = scn.nextInt();
            int ans = getMyNumber(num);
            System.out.println(ans);
        }
    }