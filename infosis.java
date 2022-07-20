import java.util.Scanner;
public class infosis{
    public static class Pair{
        int gold;
        boolean flag;
        Pair(int gold, boolean flag){
            this.gold = gold;
            this.flag = flag;
        }
    }
    public static int[][] dir = {{1,0}, {0,1}};
    public static int finalAns = 0;

    public static boolean isMagical(int row, int col, int[][] magical){
        int n = magical.length;
        for(int i=0; i<n; i++){
            if(row == magical[i][0] && col == magical[i][1])
                return true;
        }
        return false;
    }
    public static void mazePath(int sr, int sc, int dr, int dc, int[][] maze, boolean[][] vis, Pair ans, int[][] magical){
        if(sr == dr && sc == dc){
            if(ans.flag || isMagical(sr,sc, magical)){
                if(ans.gold + maze[sr][sc] > finalAns)
                    finalAns = ans.gold + maze[sr][sc];
                return;
            }else{
                return;
            }
        }

        vis[sr][sc] = true;

        if(!ans.flag){
            if(isMagical(sr, sc, magical))
                ans.flag = true;
        }

        for(int i=0; i<2; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r < maze.length && c < maze[0].length){
                mazePath(r, c, dr, dc, maze, vis, new Pair(ans.gold + maze[sr][sc], ans.flag), magical);
            }
        }

        vis[sr][sc] = false;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        int[][] maze = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                maze[i][j] = scn.nextInt();
            }
        }
        int n = scn.nextInt();
        int[][] magical = new int[n][2];
        for(int i=0; i<n; i++){
            magical[i][0] = scn.nextInt();
            magical[i][1] = scn.nextInt();
        }

        mazePath(0, 0, row-1, col-1, maze, new boolean[row][col], new Pair(0,false), magical);
        System.out.println(finalAns);
    }
}