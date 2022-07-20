import java.util.Scanner;
public class question{

    public static int ans = 0;

    public static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static int countLargestArea(int[][] ary, int sr, int sc, int lifeline, boolean flag, boolean[][] vis, int[][] dp){
        
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }

        //System.out.println("(" + sr + ", " + sc + ")" + " count -> " + count);
        
        vis[sr][sc] = true;
        ary[sr][sc] = 0;

        int count  = 0;

        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && r < ary.length && c >= 0 && c < ary[0].length && !vis[r][c]){
                if(ary[r][c] == 1){
                    count = Math.max(countLargestArea(ary, r, c, lifeline, false, vis, dp), count);
                }else if(lifeline == 1){
                    ary[r][c] = 1;
                    count = Math.max(countLargestArea(ary, r, c, 0, true, vis, dp), count);
                }
            } 
        }
        if(flag) ary[sr][sc] = 0;
        else ary[sr][sc] = 1;

        return dp[sr][sc] = count + 1;
    }

    public static int largestIsland(int[][] ary){
        int[][] dp = new int[ary.length][ary.length];

        for(int i = 0; i < ary.length; i++){
            for(int j = 0; j < ary[0].length; j++){
                if(ary[i][j] == 1){
                    int count = countLargestArea(ary, i, j, 1, false, new boolean[ary.length][ary.length], dp);
                    ans = Math.max(count, ans);
                }
            }
        }
        return ans;
    }

    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] ary = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ary[i][j] = scn.nextInt();
            }
        }

        System.out.println(largestIsland(ary));

    }
}