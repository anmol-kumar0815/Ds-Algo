import java.util.Scanner;
public class swiflearn{
    public static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static boolean flag = false;
    public static int count = 0;

    public static void mazePath(int sr, int sc, int dr, int dc, Character[][] maze, boolean[][] vis, int lifeLine){

        if(sr == dr && sc == dc){
            if(lifeLine == 0){
                count++;
                flag = true;
            }else{
                flag = true;
            }
            return;
        }

        vis[sr][sc] = true;

        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && c >= 0 && r <= dr && c <= dc && !vis[r][c]){
                if(maze[r][c] == '0' && lifeLine == 1){
                    mazePath(r, c, dr, dc, maze, vis, lifeLine-1);
                }
                else if(maze[r][c] == '1'){
                    mazePath(r, c, dr, dc, maze, vis, lifeLine);
                }
            }
        }
        vis[sr][sc] = false;
    }


    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] que = new String[n];

        for(int i=0; i<n; i++){
            que[i] = scn.next();
        }

        String str = que[0];
        Character[][] maze = new Character[n][str.length()];

        int level = 0;
        for(String str1 : que){
            for(int i=0; i<str1.length(); i++){
                maze[level][i] = str1.charAt(i);
            }
            level++;
        }

        mazePath(0, 0, maze.length-1, maze[0].length-1, maze, new boolean[n][str.length()], 1);

        if(count == 0 && !flag){
            System.out.println("Not Possible");
        }else if(count > 0 && flag){
            System.out.println(count);
        }else if(count == 0 && flag){
            System.out.println(true);
        }
    }

}