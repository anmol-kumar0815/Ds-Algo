import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayList;

public class graphLevelUp{

    //Leetcode 200 Number of island
    public int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

    public int numIslands(char[][] ary) {
        int row = ary.length;
        int col = ary[0].length;
        int count = 0;
        boolean[][] vis = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(vis[i][j] || ary[i][j] == '0') continue;
                isLand(i,j,row,col,ary,vis);
                count++;
            }
        }
        return count;
    }
    public void isLand(int sr, int sc, int row, int col, char[][] ary, boolean[][] vis){
        if(ary[sr][sc] == '0') return;
        
        vis[sr][sc] = true;
        
        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >=0 && r < row && c >=0 && c < col && vis[r][c] == false){
                isLand(r,c,row,col,ary,vis);
            }
        }
    }

    //leetcode 695 max area island
    public int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] ary) {
        int row = ary.length;
        int col = ary[0].length;
        int count = 0, maxCount = 0;
        boolean[][] vis = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(vis[i][j] || ary[i][j] == 0) continue;
                count = isLand(i,j,row,col,ary,vis);
                if(count > maxCount)
                    maxCount = count;
            }
        }
        return maxCount;
    }
    public int isLand(int sr, int sc, int row, int col, int[][] ary, boolean[][] vis){
        if(ary[sr][sc] == 0) return 0;
        
        vis[sr][sc] = true;
        int count = 0;
        
        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >=0 && r < row && c >=0 && c < col && vis[r][c] == false){
                count += isLand(r,c,row,col,ary,vis);
            }
        }
        return count + 1;
    }

    //Leetcode 463 island perimeter
    public int count = 0;
    public int islandPerimeter(int[][] ary) {
        int row = ary.length;
        int col = ary[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary[i][j] == 0 || vis[i][j]) continue;
                perimeter(i,j,ary,vis);
            }
        }
        return count;
    }
    
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public void perimeter(int sr, int sc, int[][] ary, boolean[][] vis){
        vis[sr][sc] = true;
        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && c >= 0 && r < ary.length && c < ary[0].length && !vis[r][c] && ary[r][c] == 1){
                perimeter(r,c,ary,vis);
            }else if(r < 0 || c < 0 || r >= ary.length || c >= ary[0].length || ary[r][c] == 0){
                //System.out.println(r + " " + c);
                count++;
            }
        }
    }

    //Leetcode 130 surrounded regions
    public void solve(char[][] ary) {
        int row = ary.length;
        int col = ary[0].length;
        boolean[][] vis = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if((i==0 || j == 0 || i+1==row || j+1==col) && !vis[i][j] && ary[i][j] == 'O'){
                    collectWater(i,j,ary,vis);
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary[i][j] == '#'){
                    ary[i][j] = 'O';
                }else{
                    ary[i][j] = 'X';
                }
            }
        }
    }
    
    
    public void collectWater(int sr, int sc, char[][] ary, boolean[][] vis){
        
        vis[sr][sc] = true;
        
        ary[sr][sc] = '#';
    
        
        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >=0 && r < ary.length && c >=0 && c < ary[0].length && ary[r][c]=='O' && vis[r][c] == false){
                collectWater(r,c,ary,vis);
            }
        }
        
    }
    
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};


    //number of distinct islands lintcode 860

    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public String[] dirS = {"D", "U", "R", "L"};

    public int numberofDistinctIslands(int[][] ary){
        HashSet<String> map = new HashSet<>();
        int row = ary.length;
        int col = ary[0].length;
        String path;
        boolean[][] vis = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary[i][j]==1 && !vis[i][j]){
                    path = markIsland(i,j,"",vis,ary);
                    map.add(path);
                }
            }
        }
    }
    
    public String markIsland(int sr, int sc, String path, boolean[][] vis, int[][] ary){
        vis[sr][sc] = true;
        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            path += dirS[i];
            if(r >= 0 && c >= 0 && r < ary.length && c < ary[0].length && !vis[r][c] && ary[r][c] == 1){
                path = markIsland(r, c, path, vis, ary);
            }
        }
        return path;
    }


    //Leetcode 1905 count sub-island
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean isSubIsland(int sr, int sc, int[][] ary1, int[][] ary2){
        ary2[sr][sc] = 0;
        boolean res = true;

        for(int i=0; i<4; i++){
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if(r >= 0 && c >= 0 && r < ary2.length && c < ary2[0].length && ary2[r][c] == 1){
                res = isSubIsland(r, c, ary1, ary2) && res;
            }  
        }

        return res == true && ary1[sr][sc] == 1;
    }
    public int countSubIsland(int[][] ary1, int[][] ary2){
        int row = ary1.length;
        int col = ary1[0].length;
        int count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary2[i][j] == 1){
                    count += isSubIsland(i,j,ary1,ary2) ? 1 : 0; 
                }
            }
        }
        return count;
    }

    //Leetcode 994 rotten oranges
    public int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public class pair{
        int i;
        int j;
        public pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] ary){
        int row = ary.length;
        int col = ary[0].length;
        int fresh = 0;

        LinkedList<pair> que = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(ary[i][j] == 1){
                    fresh++;
                }else if(ary[i][j] == 2){
                    que.addLast(new pair(i,j));
                }
            }
        }
        
        int ans = rottOranges(que, ary, fresh);
        return ans;
    }

    public int rottOranges(LinkedList<pair> que, int[][] ary, int fresh){
        if(fresh == 0)  return 0;
        int level = 0;
        while(que.size() > 0){

            int size = que.size();

            while(size-- > 0){
                pair node = que.removeFirst();

                if(fresh <= 0) break;

                for(int i=0; i<4; i++){
                    int r = node.i + dir[i][0];
                    int c = node.j + dir[i][1];
                    if(r >= 0 && c >= 0 && r < ary.length && c < ary[0].length){
                        if(ary[r][c] == 1)  fresh--;
                        else if(ary[r][c] == 0 || ary[r][c] == 2) continue;
                        ary[r][c] = 2;
                        que.addLast(new pair(r,c));
                    }
                }

            }
            level++;
            if(fresh <= 0){
                return level;
            }
        }
        return -1;
    }

    public class ans{
        int move;
        int state;
        boolean draw;
        ans(int move, int state, boolean draw){
            this.move = move;
            this.state = state;
            this.draw = draw;
        }
    }
    public ans dfs_Mouse(int u, int[][] graph, boolean[] visMouse, ArrayList<ans> mousePath, ans node){
        if(visMouse[u]){
            ans base = new ans(node.move, u, true);
            mousePath.add(base);
            return base;
        }
        if(u == 0){
            ans base = new ans(node.move, u, false);
            mousePath.add(base);
            return base;
        }

        visMouse[u] = true;

        mousePath.add(node);

        ans res =  dfs_Mouse(graph[u][0], graph, visMouse, mousePath, new ans(node.move+1, graph[u][0], false));
        
        return res;

    }

    public ans dfs_Cat(int u, int[][] graph, boolean[] visCat, ArrayList<ans> catPath, ans node){
        if(visCat[u]){
            ans base = new ans(node.move, u, true);
            catPath.add(base);
            return base;
        }

        visCat[u] = true;

        catPath.add(node);

        ans res =  dfs_Cat(graph[u][0] == 0 ? graph[u][1] : graph[u][0], graph, visCat, catPath, new ans(node.move+1, graph[u][0], false));

        return res;

    }
    public int game(int[][] graph){
        int n = graph.length;
        boolean[] visMouse = new boolean[n];
        boolean[] visCat = new boolean[n];
        ArrayList<ans> mousePath = new ArrayList<>();
        ArrayList<ans> catPath = new ArrayList<>();

        ans node1 = dfs_Mouse(1, graph, visMouse, mousePath, new ans(0,-1,false));
        ans node2 = dfs_Cat(2, graph, visCat, catPath, new ans(0, -1, false));

        for(int i=0; i<mousePath.size() && i< catPath.size(); i++){
            ans mouse = mousePath.get(i);
            ans cat = catPath.get(i);

            if(mouse.draw || cat.draw){
                return 0;
            }else if(mouse.state == cat.state){
                return 2;
            }else if(mouse.state == 0){
                return 1;
            }
        }

    }


    //Leetcode 1091 shortest path in binary matrix
    //For finding shortest path always use BFS instead of DFS  because of time complexity
    public int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,1}, {1,-1}, {1,1}, {-1,-1}};
    public class pair{
        int i;
        int j;
        pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int shortestPathBinaryMatrix(int[][] ary) {
        int row = ary.length;
        int col = ary[0].length;

        if(ary[0][0] == 1 || ary[row-1][col-1] == 1)
            return -1;

        return bfs(ary);
    }

    public int bfs(int[][] ary){
        boolean flag = false;
        LinkedList<pair> que = new LinkedList<>();
        que.addLast(new pair(0,0));
        int level = 0;
        while(que.size() > 0){
            
            int size = que.size();
            level++;
                
            while(size-- > 0){
                pair node = que.removeFirst();
                
                if(node.i == ary.length-1 && node.j == ary[0].length-1){
                    flag = true;
                    break;
                }
                    

            
                for(int i=0; i<dir.length; i++){
                    int r = node.i + dir[i][0];
                    int c = node.j + dir[i][1];

                    if(r >= 0 && c >= 0 && r< ary.length && c < ary[0].length && ary[r][c] == 0){
                        ary[r][c] = 1;
                        que.addLast(new pair(r,c));
                    }
                }

            }

            if(flag)
                return level;
        }

        return flag == true ? level : -1;
    }

    //Leetcode 329 longest increasing path in a matrix
    // public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void getInDegree(int[][] ary, int[][] inDegree){

        for(int i=0; i<ary.length; i++){
            for(int j=0; j<ary[0].length; j++){
                //checking in all 4 directions
                for(int k=0; k<dir.length; k++){
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    if(r >= 0 && r < ary.length && c >= 0 && c < ary[0].length && ary[r][c] > ary[i][j]){
                        inDegree[r][c]++;
                    }
                }

            }
        }

    }

    public int topological_BFS(int[][] ary, LinkedList<pair> que, int[][] inDegree){
        int level = 0;
        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                pair removedIndex = que.removeFirst();

                int i = removedIndex.i;
                int j = removedIndex.j;

                for(int k=0; k<dir.length; k++){
                    int r = i + dir[k][0];
                    int c = j + dir[k][1];
                    if(r >= 0 && r < ary.length && c >= 0 && c < ary[0].length && ary[r][c] > ary[i][j]){
                        inDegree[r][c]--;
                        if(inDegree[r][c] == 0){
                            que.addLast(new pair(r,c));
                        }
                    }
                }



            }

            level++;
        }

        return level;
    }

    public int longestIncreasingPath(int[][] ary) {
        int n = ary.length, m = ary[0].length;
        int[][] inDegree = new int[n][m];
        
        getInDegree(ary, inDegree);

        LinkedList<pair> que = new LinkedList<>();

        for(int i=0; i < n; i++){
            for(int j=0; j<m; j++){
                if(inDegree[i][j] == 0){
                    que.addLast(new pair(i,j));
                }
            }
        }

        int ans = topological_BFS(ary,que,inDegree);

        return ans;
        
    }
}