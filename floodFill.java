import java.io.*;
import java.util.*;

public class waste {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "", n-1, m-1);
    }
    
    public static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public static String[] str = {"t","l","d","r"};
    
    public static void floodfill(int[][] maze, int sr, int sc, String ans, int dr, int dc) {
        
        if(sr == dr && sc == dc){
             System.out.println(ans);
            return;
        }
        
        maze[sr][sc] = 1;
        
        for(int i=0; i<dir.length; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r>=0 && r<=dr && c>=0 && c<= dc && maze[r][c]!=1){
                floodfill(maze,r,c,ans+str[i],dr,dc);
            }
        }
        maze[sr][sc] = 0;
    }
}
