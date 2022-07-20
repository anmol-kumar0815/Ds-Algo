import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class graphImplementation{
    public static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));                        // for bi-directional graph
    }
    public static int findEdge(int u, int v, ArrayList<Edge>[] graph){
        if(u >= graph.length) return -1;

        ArrayList<Edge> list = graph[u];
        for(int i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            if(edge.v == v)
                return i;
        }
        return -1;
    }
    public static void removeEdge(int u, int v, ArrayList<Edge>[] graph){
        if(u >= graph.length || u < 0) return;
        int idx1 = findEdge(u, v, graph);
        int idx2 = findEdge(v, u, graph);
        if(idx1 == -1 || idx2 == -1) return;
        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }
    public static void removeVertex(int u, ArrayList<Edge>[] graph){
        if(u >= graph.length || u < 0) return;
        ArrayList<Edge> list = graph[u];
        while(list.size() > 0){
            Edge edge = list.get(0);
            removeEdge(u, edge.v, graph);
        }
    }
    public static boolean hasPath(int src, int des, ArrayList<Edge>[] graph, boolean[] vis){
        if(src == des) return true;
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            boolean ans = hasPath(edge.v, des, graph, vis);
            if(ans) return true;
        }
        return false;
    }
    public static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void allPaths(int src, int des, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> temp){
        temp.add(src);
        if(src == des){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            allPaths(edge.v, des, graph, vis, temp);
        }
        vis[src] = false;
        temp.remove(temp.size()-1);
    }
    public static void preOrder(int src, ArrayList<Edge>[] graph, boolean[] vis, String path, int weight){
        path += src + "";
        System.out.println(src + " -> " + path + " @ " + weight);
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            preOrder(edge.v, graph, vis, path, weight+edge.w);
        }
        vis[src] = false;
    }
    public static void postOrder(int src, ArrayList<Edge>[] graph, boolean[] vis, String path, int weight){
        path += src + "";
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            postOrder(edge.v, graph, vis, path, weight+edge.w);
        }
        System.out.println(src + " -> " + path + " @ " + weight);
        vis[src] = false;
    }
    // longest and smallest path in terms of weight, kth longest path in terms of weight
    public static class pair{
        int longestWeight = -(int)(1e9);
        int smallestWeight = (int)(1e9);
        String longestPath = "";
        String smallestPath = "";
        int ceil = (int)(1e9);
        int floor = -(int)1e9;
    }
    public static class pqPair{
        int weight;
        String path;
        public pqPair(int weight, String path){
            this.weight = weight;
            this.path = path;
        }
    }
    public static PriorityQueue<pqPair> pq = new PriorityQueue<>((a,b) -> {
        return a.weight - b.weight;
    });
    public static pair allSolutions(int src, int des, int weight, String path, boolean[] vis,ArrayList<Edge>[] graph, pair node, int givenWeight, int k){
        if(src == des){
            if(weight < node.smallestWeight){
                node.smallestWeight = weight;
                node.smallestPath = path;
            }else if(weight > node.longestWeight){
                node.longestWeight = weight;
                node.longestPath = path;
            }
            if(weight > givenWeight)
                node.ceil = Math.min(node.ceil, weight);
            if(weight < givenWeight)
                node.floor = Math.max(node.floor, weight);

            //adding path and weight in priority queue
            pqPair node1 = new pqPair(weight, path);
            pq.add(node1);
            if(pq.size() > k)
                pq.remove();
            return node;
        }
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            node = allSolutions(edge.v, des, weight + edge.w, path + " -> " + edge.v +"", vis, graph, node, givenWeight, k);
        }
        vis[src] = false;
        return node;
    }
    public static void justSmallerAndLarger(String str, int weight){
        for(pqPair temp : pq){
            if(temp.weight == weight){
                System.out.println(str + " = " + temp.path+"@"+temp.weight);
            }
        }
    }
    public static void dfs(int src, ArrayList<Edge>[] graph, boolean[] vis){
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            dfs(edge.v, graph, vis);
        }
    }
    public static int gccCount(ArrayList<Edge>[] graph, boolean[] vis){
        int components = 0, n = graph.length;
        for(int i=0; i<n; i++){
            if(vis[i] || graph[i].size()==0) continue;
            dfs(i, graph, vis);
            components++;
        }
        return components;
    }
    public static ArrayList<Integer> traverseGraph(int src, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> temp){
        temp.add(src);
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            traverseGraph(edge.v, graph, vis, temp);
        }
        return temp;
    }
    public static ArrayList<ArrayList<Integer>> getConnectedComponent(ArrayList<Edge>[] graph, boolean[] vis){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(graph[i].size()==0 || vis[i] == true) continue;
            ArrayList<Integer> temp = traverseGraph(i, graph, vis, new ArrayList<>());
            ans.add(temp);
        }
        return ans;
    }
    //Count number of island where 0 is land and 1 is water;
    public static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void isIsland(int[][] ary, boolean[][] vis, int row, int col){
        vis[row][col] = false;
        for(int i=0; i<4; i++){
            int r = row + dir[i][0];
            int c = col + dir[i][1];
            if(r >= 0 && r < ary.length && c>=0 && c<ary[0].length && vis[r][c]){
                isIsland(ary,vis,r,c);
            }
        }
    }
    public static int numberOfIsland(int[][] ary, boolean[][] vis){
        int row = ary.length, col = ary[0].length, count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!vis[i][j]) continue;
                isIsland(ary, vis, i, j);
                count++;
            }
        }
        return count;
    }
    public static void traverseGraph(int src, ArrayList<Edge>[] graph, boolean[] vis){
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            traverseGraph(edge.v, graph, vis);
        }
    }
    public static boolean isConnectedGraph(ArrayList<Edge>[] graph, boolean[] vis){
        int components = 0;
        for(int i=0; i<graph.length; i++){
            if(graph[i].size()==0 || vis[i] == true) continue;
            traverseGraph(i, graph, vis);
            components++;
        }
        return components == 1;
    }
    
    //hamiltonianPaths and cycle
    public static boolean isAllVisited(boolean[] ary){
        for(int i=0; i<ary.length; i++){
            if(ary[i] == false){
                return false;
            }
        }
        return true;
    }
    public static void hamiltonianPaths(int curr, int src, String path, boolean[] vis, ArrayList<Edge>[] graph){
        vis[curr] = true;
        if(isAllVisited(vis)){
            char post = '.';
            ArrayList<Edge> list = graph[curr];
            for(Edge edge : list){
                if(edge.v == src){
                    post = '*';
                    break;
                }
            }
            System.out.println(path + post);
            vis[curr] = false;
            return;
        }
        ArrayList<Edge> list = graph[curr];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            hamiltonianPaths(edge.v, src, path + edge.v + "", vis, graph);
        }
        vis[curr] = false;
    }
    //Journey to moon hackerrank question 
    public static int moonDFS(int src, boolean[] vis, ArrayList<Integer>[] graph){
        vis[src] = true;
        int size = 0;
        ArrayList<Integer> list = graph[src];
        for(int v : list){
            if(vis[v]) continue;
            size += moonDFS(v,vis,graph);
        }
        return size + 1;
    }
    public static Long journeyToMoon(int n, List<List<Integer>> ary) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        int pair = ary.get(0).get(1);
        for(int i=0; i<ary.size(); i++){
            int u = ary.get(i).get(0);
            int v = ary.get(i).get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        ArrayList<Integer> sizeOfComponents = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(vis[i]) continue;
            int size = moonDFS(i, vis, graph);
            sizeOfComponents.add(size);
        }
        long sum = 0;
        for(int ele : sizeOfComponents){
            //System.out.print(ele + " ");
            sum += ele;
        }
        //calculating number of combinations
        long ans = 0;
        for(int i=0; i<sizeOfComponents.size(); i++){
            sum = sum - sizeOfComponents.get(i);
            ans += sum * sizeOfComponents.get(i);
        }
        return ans;
    }

    public static int BFS_Cycle(int src, ArrayList<Edge>[] graph, boolean[] vis){
        //It will return the cycle of a component not for all graph 
        int level = 0, cycleCount = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int removedVertex = que.removeFirst();
                if(vis[removedVertex])
                    cycleCount++;
                else
                    vis[removedVertex] = true;

                ArrayList<Edge> list = graph[removedVertex];
                for(Edge edge : list){
                    if(vis[edge.v]) continue;
                    que.addLast(edge.v);
                }
            }
            level++;
        } 
        return cycleCount;
    }
    public static boolean cycle(ArrayList<Edge>[] graph, boolean[] vis){
       int n = graph.length;
       for(int i=0; i<n; i++){
           if(graph[i].size() == 0 || vis[i]) continue;
           int cycle = BFS_Cycle(i, graph, vis);
           if(cycle > 0)
            return true;
       }
       return false;
   }

    public static void BFS(int src, ArrayList<Edge>[] graph, boolean[] vis){
        int level = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;
        while(que.size() != 0){
            int size = que.size();
            System.out.println("level -> " + level);
            while(size-- > 0){
                int removedVertex = que.removeFirst();
                System.out.print(removedVertex + " ");
                ArrayList<Edge> list = graph[removedVertex];
                for(Edge edge : list){
                    if(vis[edge.v]) continue;
                    que.addLast(edge.v);
                    vis[edge.v] = true;
                }
            }
            level++;
            System.out.println();
        } 
    }
    public static boolean isTree(ArrayList<Edge>[] graph){
        //No cycle and gcc count is 1
        int cycleCount = BFS_Cycle(0, graph, new boolean[graph.length]);
        int gcc = gccCount(graph, new boolean[graph.length]);
        System.out.println("Cycle = " + cycleCount);
        System.out.println("gcc = " + gcc);
        if(cycleCount == 0 && gcc<=1)
            return true;
        return false;
    }
    public static boolean isForest(ArrayList<Edge>[] graph){
        //No cycle and gcc count > 1
        int cycleCount = BFS_Cycle(0, graph, new boolean[graph.length]);
        int gcc = gccCount(graph, new boolean[graph.length]);
        System.out.println("Cycle = " + cycleCount);
        System.out.println("gcc = " + gcc);
        if(cycleCount == 0 && gcc>1)
            return true;
        return false;
    }
    public static boolean isBipartite(int src, ArrayList<Edge>[] graph, int[] vis){
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0, flag;
        que.addLast(src);
        while(que.size() > 0){
            int size = que.size();
            flag = level % 2;
            while(size-- > 0){
                int removedVertex = que.removeFirst();
                vis[removedVertex] = flag;

                ArrayList<Edge> list = graph[removedVertex];
                for(Edge edge : list){
                    if(vis[edge.v] == -1){
                        que.addLast(edge.v);
                    }else if(vis[edge.v] != (level+1) % 2){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
    public static boolean isGraphBipartite(ArrayList<Edge>[] graph){
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        for(int i=0; i<graph.length; i++){
            if(graph[i].size() == 0 || vis[i] != -1) continue;
            boolean ans = isBipartite(i, graph, vis);
            if(!ans) return false;
        }
        return true;
    }
    public static int infectionSpread(int src, int t, ArrayList<Edge>[] graph, boolean[] vis){
        //use simple BFS
        int level = 0, count = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        count++;
        vis[src] = true;
        while(que.size() != 0){
            int size = que.size();
            if(t == 1)
                return count;
            while(size-- > 0){
                int removedVertex = que.removeFirst();

                ArrayList<Edge> list = graph[removedVertex];
                for(Edge edge : list){
                    if(vis[edge.v]) continue;
                    que.addLast(edge.v);
                    count++;
                    vis[edge.v] = true;
                }
            }
            t--;
            level++;
        } 
        return count;
    }
    public static void display(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            ArrayList<Edge> list = graph[i];
            if(list.size() == 0) continue;
            System.out.print(i + " -> ");
            for(Edge edge : list){
                System.out.print("(" + edge.v + "," + edge.w + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();
            addEdge(u,v,w,graph);
        }
        //display(graph);
        // removeEdge(3, 4, graph);
        System.out.println(infectionSpread(6, 3, graph, new boolean[n]));
        
    }
}



//Take this input for making graph
        // 8   
        // 0 3 10
        // 0 1 10
        // 1 2 10
        // 2 3 40
        // 3 4 2
        // 4 5 2
        // 5 6 3
        // 6 4 8