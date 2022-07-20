import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
public class dpLevelUp{

    public static void print2D(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print1D(int[] dp){
        for(int i=0; i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }

    public static int fibonacci(int n){
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci_memo(int n, int[] dp){
        if(n <= 1){
            return dp[n] = n;
        } 

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fibonacci_memo(n-1, dp) + fibonacci_memo(n-2,dp);
    }

    public static int fibonacci_tabu(int N, int[] dp){
        for(int n = 0; n <=N; n++){
            if(n <= 1){
                dp[n] = n;
                continue;
           }
   
            dp[n] = dp[n-1] + dp[n-2];
        }
        return dp[N];
    }

    public static void fibonacci_optimized(int n){
        int a = 0, b = 1, c=1;
        while(n-- > 0){
            System.out.println(a + " ");
            a = b;
            b = c;
            c = a+b;
        }
    }
    //Faith: har ceil se ye faith h ki vo apne se destination tk jaane k saare raaste count kr k le aaega

    public static int[][] dir = {{0,1}, {1,0}, {1,1}};
    public static String[] dirS = {"R", "D", "Dia"};

    //Recursion
    public static int mazePath(int sr, int sc, int dr, int dc, String path){

        if(sr == dr && sc == dc){
            System.out.println(path);
            return 1;
        }
        
        int count = 0;
        
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            
            if(r >= 0 && r <= dr && c >= 0 && c <= dc){
                count += mazePath(r,c,dr,dc, path + "->" + dirS[i] + "");
            }
        }
        
        return count;
        
    }
    
    //Memorization
    public static int mazePath_memo(int sr, int sc, int dr, int dc, int[][] dp){
        if(sr == dr && sc == dc){
            return dp[sr][sc] = 1;
        }
        
        if(dp[sr][sc] != -1)
            return dp[sr][sc];
        
        int count = 0;
        
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r <= dr && c >= 0 && c <= dc){
                count += mazePath_memo(r,c,dr,dc,dp);
            }
        }
        
        return dp[sr][sc] = count;
        
    }
    
    //Tabulation
    public static int mazePath_tabu(int SR, int SC, int DR, int DC, int[][] dp){
        for(int sr = DR; sr >= SR; sr--){
            for(int sc = DC; sc >= SC; sc--){

                if(sr == DR && sc == DC){
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;

                for(int i=0; i<dir.length; i++){
                    int r = sr + dir[i][0];
                    int c = sc + dir[i][1];
                    if(r >= 0 && r <= DR && c >= 0 && c <= DC){
                        count += dp[r][c];
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    //Recursion
    public static int mazePathWithJump(int sr, int sc, int dr, int dc){
        if(sr == dr && sc == dc){
            return 1;
        }

        int count = 0;

        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r <= dr && c >= 0 && c <= dc){
                count += mazePathWithJump(r, c, dr, dc); 
            }
        }

        return count;
    }

    //Recursion
    //faith : hr ceil apna aur apne se aage ka max gold return  kr dega
    public static int maxGold(int sr, int sc, int[][] gold, int[][] dir){
        int count = 0;
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r < gold.length && c >= 0 && c < gold[0].length){
                count = Math.max(maxGold(r, c, gold, dir), count);
            }
        }
        return count + gold[sr][sc];
    }

    //Memorization
    public static int maxGold_memo(int sr, int sc, int[][] gold, int[][] dir, int[][] dp){
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }

        int count = 0;
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r < gold.length && c >= 0 && c < gold[0].length){
                count = Math.max(maxGold_memo(r, c, gold, dir, dp), count);
            }
        }
        return dp[sr][sc] = count + gold[sr][sc];
    }

    //Tabulation
    public static int maxGold_tabu(int SR, int SC, int[][] gold, int[][] dir, int[][] dp){
        for(int sc = gold[0].length-1; sc >= 0; sc--){
            for(int sr = gold.length-1; sr >= 0; sr--){

                int count = 0;

                for(int i=0; i<dir.length; i++){
                    int r = sr + dir[i][0];
                    int c = sc + dir[i][1];
                    if(r >= 0 && r < gold.length && c >= 0 && c < gold[0].length){
                        count = Math.max(dp[r][c], count);
                    }
                }

                dp[sr][sc] = count + gold[sr][sc];
            }
        }

        return dp[SR][SC];
        
    }

    public static int goldMine(int[][] gold){
        int n = gold.length;
        int m = gold[0].length;
        int[][] dir = {{0,1}, {-1,1}, {1,1}};

        int[][] dp = new int[n][m];
        for(int[] ary : dp)
            Arrays.fill(ary, -1);

        int ans = 0;
        for(int i=0; i<gold.length; i++){
            ans = Math.max(maxGold_tabu(i, 0, gold, dir, dp), ans);
        }
        return ans;
    }

    //LeetCode 1219, 70, 746
    //Recursion
    public static int maxGold(int sr, int sc, int[][] gold, boolean[][] vis, int[][] dir){
        vis[sr][sc] = true;
        
        int count = 0;
        
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r < gold.length && c >= 0 && c < gold[0].length && vis[r][c] == false && gold[r][c] != 0){
                count = Math.max(maxGold(r, c, gold, vis, dir), count);
            }
        }
        
        vis[sr][sc] = false;
        return count + gold[sr][sc];
    }
    
    public static int getMaximumGold(int[][] gold) {
        int n = gold.length;
        int m = gold[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                 if(gold[i][j] != 0){
                      ans = Math.max(maxGold(i, j, gold, new boolean[n][m], dir), ans);
                 } 
            }
        }
        return ans;
    }

    //Leetcode 70
    public static int minCostClimbingStairs_memo(int idx, int[] cost, int[] dp){
        if(idx == 1 || idx == 0){
            dp[idx] = cost[idx];
            return cost[idx];
        }
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int onecost = minCostClimbingStairs_memo(idx - 1, cost, dp);
        int twocost = minCostClimbingStairs_memo(idx - 2, cost, dp);
        
        int ans = Math.min(onecost, twocost) + (idx == cost.length ? 0 : cost[idx]);
        return dp[idx] = ans;
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp,-1);
        return minCostClimbingStairs_memo(cost.length,cost,dp);
    }

    //Recursion
    public static int boardPath(int sum, int target){
        if(sum == target){
            return 1;
        }

        int count = 0;
        for(int i=1; i<=6; i++){
            if(sum + i <= target)
                count += boardPath(sum + i, target);
        }
        return count;
    }
    
    public static int boardPath_Opti(int n) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(1);
        for (int i = 2; i <= n; i++) {
            if (ll.size() <= 6) 
                ll.addLast(ll.getLast() * 2);
            else
                ll.addLast(ll.getLast() * 2 - ll.removeFirst());
        }

        return ll.getLast();
    }

    //Memorization
    public static int boardPath_memo(int sum, int target, int[] dp){  
        if(sum == target){
            return dp[sum] = 1;
        }

        if(dp[sum] != -1)
            return dp[sum];

        int count = 0;
        for(int i=1; i<=6; i++){
            if(sum + i <= target)
                count += boardPath_memo(sum + i, target, dp);
            else
                break;
        }

        return dp[sum] = count;
    }
    //tabulation
    public static int boardPath_tabu(int target, int[] dp){  
        for(int sum=target; sum>=0; sum--){

            if(sum == target){
                dp[sum] = 1;
                continue;
            }

            for(int i=1; i<=6; i++){
                if(sum + i <= target)
                    dp[sum] +=  dp[sum + i];           //boardPath_memo(sum + i, target, dp);
                else
                    break;
            }

        }
        return dp[0];
    }

    //Recursion
    public static int boardPathWithArray(int sum, int[] moves, int target){
        if(sum == target){
            return 1;
        }

        int count = 0;
        for(int i=0; i<moves.length; i++){
            if(sum + moves[i] <= target)
                count += boardPathWithArray(sum + moves[i], moves, target);
        }
        return count;
    }

    //Memorization
    public static int boardPathWithArray_memo(int sum, int[] moves, int target, int[] dp){
        if(sum == target){
            return dp[sum] = 1;
        }

        if(dp[sum] != -1)
            return dp[sum];

        int count = 0;
        for(int i=0; i<moves.length; i++){
            if(sum + moves[i] <= target)
                count += boardPathWithArray_memo(sum + moves[i], moves, target, dp);
        }
        return dp[sum] = count;
    }

    //tabulation
    public static int boardPathWithArray_tabu(int sum, int[] moves, int target, int[] dp){
        for(sum=target; sum >=0; sum--){
            if(sum == target){
                dp[sum] = 1;
                continue;
            }
    
            for(int i=0; i<moves.length; i++){
                if(sum + moves[i] <= target)
                    dp[sum] += dp[sum + moves[i]];    //boardPathWithArray_memo(sum + moves[i], moves, target, dp);
            }
        }
        return dp[0];
    }

    // Leetcode 91 decode ways
    //Recursion
    public static ArrayList<String> list = new ArrayList<>();
    public static int numDecodingsWays(String que, String ans){
        if(que.length() == 0){
            list.add(ans);
            return 1;
        }

        if(que.charAt(0) == '0') return 0;

        int count = 0;
        char ch = que.charAt(0);
        String ros = que.substring(1);


        count += numDecodingsWays(ros, ans + ch + ",");

        if(que.length() >= 2){
            String twoch = que.substring(0,2);
            ros = que.substring(2);

            if(Integer.parseInt(twoch) <= 26)
                count+= numDecodingsWays(ros, ans + twoch + ",");
        }
        return count;

    }

    //Memorization
    public static int numDecodingsWays_memo(String que, String ans, int idx, int[] dp){
        if(que.length() == 0){
            return 1;
        }

        if(que.charAt(0) == '0'){
            return dp[idx] = 0;
        } 

        if(dp[idx] != -1)
            return dp[idx];

        int count = 0;
        char ch = que.charAt(0);
        String ros = que.substring(1);


        count += numDecodingsWays_memo(ros, ans + ch + ",", idx+1, dp);

        if(que.length() >= 2){
            String twoch = que.substring(0,2);
            ros = que.substring(2);

            if(Integer.parseInt(twoch) <= 26)
                count+= numDecodingsWays_memo(ros, ans + twoch + ",", idx + 2, dp);
        }
        return dp[idx] = count;
    }


    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] gold = new int[n][m];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         gold[i][j] = scn.nextInt();
        //     }
        // }

        //System.out.println(goldMine(gold));
        int[] dp = new int[3];
        Arrays.fill(dp,-1);
        // int[] moves = {2,6,7,8};
        System.out.println(numDecodingsWays_memo("226", "", 0,  dp));
        System.out.println(list);
    }
}