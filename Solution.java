import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public static class pair{
        int r, c;
        pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public class node{
        pair rowCol;
        int size;
        node(pair c, int s){
            this.rowCol = c; this.size = s;
        }
    }
    //Leetcode 695
    public int maxAreaOfIsland(int[][] ary) {
        int row = ary.length, col = ary[0].length;
        node[][] unionSet = new node[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                unionSet[i][j] = new node(new pair(i,j), ary[i][j] == 1 ? 1 : 0);
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary[i][j] == 1){
                    findNeighbour(i, j, ary, unionSet);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                // System.out.print(i + " , " + j + " par-> ");
                // System.out.println(unionSet[i][j].rowCol.r + " , " + unionSet[i][j].rowCol.c + " Size -> " + unionSet[i][j].size);
                if(ans < unionSet[i][j].size) ans = unionSet[i][j].size;
            }
        }
        
        //System.out.println(unionSet[2][3].rowCol.r + " ");
        

        return ans;
        
    }
    public node findParent(int i, int j, node[][] unionSet){
        if(i == unionSet[i][j].rowCol.r && j == unionSet[i][j].rowCol.c){
            return unionSet[i][j];
        }
        node lead = findParent(unionSet[i][j].rowCol.r,  unionSet[i][j].rowCol.c, unionSet);
        unionSet[i][j].rowCol.r = lead.rowCol.r; unionSet[i][j].rowCol.c = lead.rowCol.c;
        return lead;
    }
    
    public int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    
    public void findNeighbour(int i, int j, int[][] ary, node[][] unionSet){
        node L1 = findParent(i,j,unionSet);
        for(int k=0; k<dir.length; k++){
            
            int r = i + dir[k][0]; int c = j + dir[k][1];
            
            if(r>=0 && c>=0 && r < ary.length && c < ary[0].length && ary[r][c] == 1){
                node L2 = findParent(r,c, unionSet);
                
                if(L2.rowCol.r == L1.rowCol.r && L2.rowCol.c == L1.rowCol.c) continue;
                
                else{
                    //System.out.println(L2.rowCol.r+","+L2.rowCol.c + " -> "+ L2.size);
                    if(L2.size > L1.size){
                        L2.size += L1.size;
                        L1.rowCol.r = L2.rowCol.r; L1.rowCol.c = L2.rowCol.c;
                        //System.out.println(L2.size);
                    }else{
                        L1.size += L2.size;
                        L2.rowCol.r = L1.rowCol.r; L2.rowCol.c = L1.rowCol.c;
                        //System.out.println(L1.size);
                    }
                }
            }
        }
    }

    //leetcode 1061 lexicographically-smallest-equivalent-string
    public static int findLead(int ch, int[] fre){
        if(ch == fre[ch]) return ch;
        int l = findLead(fre[ch], fre);
        return fre[ch] = l;
    }
    public static String SmallestEquivalentString(String s1, String s2, String baseStr){
        int[] fre = new int[26];
        for(int i=0; i<26; i++) fre[i] = i;

        for(int i=0; i<s1.length(); i++){
            int ch1 = (int)(s1.charAt(i) - 97);
            int ch2 = (int)(s2.charAt(i) - 97);

            int l1 = findLead(ch1, fre);
            int l2 = findLead(ch2, fre);

            if(l1 == l2) continue;

            if(l1 < l2) fre[l2] = l1;
            else fre[l1] = l2;
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<baseStr.length(); i++){
            int ch = (int)(baseStr.charAt(i) - 97);
            int l = findLead(ch, fre);
            char ansCh = (char)('a' + l);
            ans.append(ansCh); 
        }

        // for(int i=0; i<26; i++){
        //     System.out.println(i + " -> " + fre[i]);
        // }
        return ans.toString();
    } 


    //leetcode 990
    public boolean equationsPossible(String[] equations) {
        int[] unionSet = new int[26];
        for(int i=0; i<26; i++) unionSet[i] = i;

        for(String str : equations){
            char ch1 = str.charAt(0), ch2 = str.charAt(1), ch3 = str.charAt(3);
            if(ch2 == '='){
                int l1 = findLead((int)(ch1-'a'), unionSet);
                int l2 = findLead((int)(ch2-'a'), unionSet);

                if(l1 == l2) continue;

                if(l1 < l2) unionSet[l2] = l1;
                else unionSet[l1] = l2;
            }
        }
        for(String str : equations){
            char ch1 = str.charAt(0), ch2 = str.charAt(1), ch3 = str.charAt(3);
            if(ch2 == '!'){
                int l1 = findLead((int)(ch1-'a'), unionSet);
                int l2 = findLead((int)(ch2-'a'), unionSet);

                if(l1 == l2) return false;
            }
        }
        return true;
    }

    //leetcode 839
    public boolean isSimilar(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if(count > 2) return false;
        }
        return true;
    }
    public int numSimilarGroups(String[] str) {
        int n = str.length, groups = str.length;
        int[] unionSet = new int[n];
        for(int i=0; i<n; i++) unionSet[i] = i;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(str[i], str[j])){
                    int l1 = findLead(i, unionSet);
                    int l2 = findLead(j, unionSet);

                    if(l1 != l2){
                        unionSet[l2] = l1;
                        groups--;
                    }
                }
            }
        }
        return groups;
    }
    
    //leetcode 303 [solved on lint code lintcode 434]
    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ansAry = new ArrayList<>();
        if(operators == null || operators.length == 0) return ansAry;

        int[][] grid = new int[n][m];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        pair[][] unionSet = new pair[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                unionSet[i][j] = new pair(i,j);
            }
        }

        int count = 0;
        for(Point cor : operators){
            int x = cor.x, y = cor.y;
            if(grid[x][y] == 1) {ansAry.add(count); continue;}
            grid[x][y] = 1;
            count++;
            count = isConnected(grid, x, y, dir, unionSet, count);
            ansAry.add(count);
        }
        return ansAry;
    }
    public static pair findLead(int r, int c, pair[][] unionSet){
        if(r == unionSet[r][c].r && c == unionSet[r][c].c) return unionSet[r][c];
        pair l = findLead(unionSet[r][c].r, unionSet[r][c].c, unionSet);
        unionSet[r][c].r = l.r; unionSet[r][c].c = l.c;
        return l;
    }
    public static int isConnected(int[][] grid, int x, int y, int[][] dir, pair[][] unionSet, int count){
        for(int i=0; i<dir.length; i++){
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                pair l1 = findLead(r, c, unionSet);
                pair l2 = findLead(x, y, unionSet);
                if(l1.r == l2.r && l1.c == l2.c) continue;
                l2.r = l1.r; l2.c = l1.c;
                count--;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int s = scn.nextInt();

        Point[] op = new Point[s];
        for(int i=0; i<s; i++){
            int u = scn.nextInt();
            int v =scn.nextInt();
            op[i] = new Point(u,v);
        }
        System.out.println(numIslands2(n,m,op));
    }
}