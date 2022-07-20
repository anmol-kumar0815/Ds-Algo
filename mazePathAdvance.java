import java.util.Scanner;
public class mazePathAdvance{
    public static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{1,1},{-1,-1},{1,-1}};
    public static String[] dirans = {"l","r","t","d","e","s","n","w"};
    public static class pair{
        int count;
        String longest;
        String shortest;
        pair(int count, String longest, String shortest){
            this.count = count;
            this.longest = longest;
            this.shortest = shortest;
        }
    }

    public static pair mazePath(int sr,int sc,int dr,int dc,int[][] maze,pair node, String ans){
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return new pair(1,ans.length() > node.longest.length() ? ans : node.longest, ans.length() < node.shortest.length() ? ans : node.shortest);
        }
        maze[sr][sc] = 1;

        pair node1 = new pair(0,"","");

        for(int i=0; i<8; i++){
            int r = dir[i][0];
            int c = dir[i][1];
            if(r>=0 && c>=0 && r<=dr && c<=dc && maze[r][c]!=1){
                node.longest += dirans[i];
                node.shortest += dirans[i];
                node1 = mazePath(r,c,dr,dc,maze,node,ans+dirans[i]);
                node.longest = node.longest.substring(0,node.longest.length());
                node.shortest = node.shortest.substring(0,node.shortest.length());
            }
        }

        maze[sr][sc] = 0;

        return node1;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] maze = new int[m][n];
        pair node = new pair(0,"","");
        pair ans = new pair(0,"","");
        ans = mazePath(0,0,m-1,n-1,maze,node,"");
        System.out.println("Count = " + ans.count);
        System.out.println("Longest Path = " + ans.longest);
        System.out.println("Shortest Path = " + ans.shortest);
    }
}