import java.util.Scanner;
public class Dp{
    public static void print(int[] ary){
        for(int ele : ary){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    public static void print2D(int[][] ary){
        for(int i=0; i<ary.length; i++){
            for(int j=0; j<ary[0].length; j++){
                System.out.print(ary[i][j] + " ");
            }
        }
    }
    public static int fibo_recurvise(int n){
        if(n==0 || n == 1){
            return n;
        }
        return fibo_recurvise(n-1) + fibo_recurvise(n-2);
    }
    //Memorization = Top-Down Approach [Final(Top) state to Base state]
    public static int fibo_memo(int n, int[] dp){
        if(n <= 1){
            return dp[n] = n;
        }

        if(dp[n] != 0)
            return dp[n];

        int ans = fibo_memo(n-1,dp) + fibo_memo(n-2, dp);
        return dp[n] = ans;                                    
    }
    //Tabulation = Bottum-Up Approach [Base state to final(top) state]
    public static int fibo_DP(int n, int[] dp){
        for(int i=0; i<=n; i++){
            if(i <= 1){                   //dp[] = {0,1,1,2,3,5,8}
                dp[i] = i;             
                continue;
            }
                        
            int ans = dp[i-1] + dp[i-2];
            dp[i] = ans;
        }

        return dp[n];
    }
    public static int fibo_opti(int n){
        int a=0,b=1,c=1;
        while(n-- > 0){
            System.out.print(a + " ");
            a = b; 
            b = c;
            c = a + b;
        }
        return a;
    }
    public static int Dice(int n){
        if(n == 10){
            return 1;
        }
        int count = 0;
        for(int i=1; i<=6 && i+n <= 10; i++){
            count += Dice(i+n);
        }
        return count;
    }
    public static int dice_memo(int n, int[] dp){
        if(n == 10){
            return dp[n] = 1;
        }

        if(dp[n] != 0)
            return dp[n];

        int count = 0;

        for(int i=1; i<=6 && i+n<=10; i++){
            count += dice_memo(n+i, dp);
        }
        return dp[n] = count;
    }
    public static int dice_dp(int n, int[] dp){
        for(int i=0; i<=10; i++){
            if(i <= 1){
                dp[i] = 1;
                continue;
            }
            int sum = 0;
            for(int j=0; j<i; j++){
                sum += dp[j];
            }
            if(i > 6){
                for(int k=0; k<i % 6; k++){
                    sum -= dp[k];
                }
            } 
            dp[i] = sum;
        }
        return dp[10-n];
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        //int n = scn.nextInt();
        int[] dp = new int[11];
        //System.out.println(ans);
        //int ans2 = Dice(0);
        int ans2 = dice_dp(0,dp);
        System.out.println(ans2);
        print(dp);
    }
}