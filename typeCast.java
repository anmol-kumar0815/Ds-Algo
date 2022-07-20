import java.util.Scanner;
public class typeCast{
    public static int digitCount(int num){
        int count = 0;
        while(num != 0){
            num = num / 10;
            count++;
        }
        return count;
    }
    public static int pow(int base, int pow){
        int ans = 1;
        while(pow-- > 0){
            ans *= base;
        }
        return ans;
    }
    public static String integerToString(int num){
        String ans = "";
        int digit = digitCount(num);
        int p = pow(10, digit - 1), que;
        while(num != 0){
            que = num / p;
            num %= p;
            p /= 10;
            ans += que + "";
        }
        return ans;
    }
    public static int stringToInteger(String str){
        int n = str.length();
        int p = pow(10, n-1);
        int res = 0, i=0;
        while(i < n){
            res = res + (str.charAt(i) - '0') * p;
            p /= 10;
            i++;
        }
        return res;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.println(stringToInteger("12345"));
        System.out.println(integerToString(15236)); 
    }
}