import java.util.Scanner;
public class mazePairFinal{
    public static class pair{
        int count;
        boolean flag;
        pair(int count, boolean flag){
            this.count = count;
            this.flag = flag; 
        }
    }

    public static pair maze(int sr, int sc, int dr, int dc, int[][] vis, pair node, int i, int j, String ans){
        //Base case
        if(sr==dr && sc==dc){
            if(node.flag == true){
                pair node1 = new pair(1,true);
                System.out.println(ans);
                return node1;
            }else if(i==sr && j==sc){
                pair node1 = new pair(1,true);
                System.out.println(ans);
                return node1;
            }else{
                pair node1 = new pair(0,false);
                return node1;
            }
        }

        vis[sr][sc] = 1;

        pair node1 = new pair(0,false);
        if(node.flag==false){
            if(sr==i && sc ==j){
                node1.count = 0;
                node1.flag = true;
            }
            else{
                node1.count = 0;
                node1.flag = false;
            }
        }else{
            node1.count = 0;
            node1.flag = true;
        }
        
        //Right call
        pair rightans = new pair(0,false);

        int r = sr + 0;
        int c = sc + 1;
        if(r<=dr && c<=dc && vis[r][c]!=1)
            rightans = maze(r,c,dr,dc,vis,node1,i,j,ans+"r");
        
        //Down call
        pair downans = new pair(0,false);
        r = sr + 1;
        c = sc + 0;
        if(r<=dr && c<=dc && vis[r][c]!=1)
            downans = maze(r,c,dr,dc,vis,node1,i,j,ans+"d");

        vis[sr][sc] = 0;

        return new pair(rightans.count+downans.count,false);
        
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int[][] vis = new int[m][n];
        pair ans = new pair(0,false);
        ans = maze(0,0,m-1,n-1,vis,ans,i,j,"");
        System.out.println(ans.count);
    }
}