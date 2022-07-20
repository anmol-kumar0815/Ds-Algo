import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
public class directedGraph{
    public static class Edge{
        int v;
        int w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void addEdge(int u, int v, int w, ArrayList<Integer>[] graph){
        graph[u].add(v);
    }

    public static boolean topological_DFS(int u, ArrayList<Integer>[] graph, boolean[] currVis, boolean[] vis, ArrayList<Integer> ans){
        currVis[u] = true;
        vis[u] = true;

        boolean isCycle = false;

        ArrayList<Integer> list = graph[u];
        
        for(int v : list){
            if(currVis[v]){
                return true;
            }

            if(vis[v]) continue;

            isCycle = topological_DFS(v, graph, currVis, vis, ans);

            if(isCycle){
                return true;
            }
        }

        currVis[u] = false;
        ans.add(u);
        return isCycle;
    }

    public static void topologicalSort_DFS(ArrayList<Integer>[] graph){
        int n = graph.length;

        for(int i=0; i<n; i++){
            if(graph[i].size() == 0) continue;

            boolean[] currVis = new boolean[n];
            boolean[] vis = new boolean[n];
            ArrayList<Integer> ans = new ArrayList<>();

            boolean isCycle = topological_DFS(i, graph, currVis, vis, ans);

            if(isCycle){
                System.out.println("There is a cycle in this graph");
                return;
            }

            if(ans.size() == n){
                System.out.println(ans);
                return;
            }
        }
    }

    //kahn's algorothm for topological sort
    public static void khanTopologicalSort(ArrayList<Edge>[] graph, int[] inDegree, ArrayList<Integer> ans, LinkedList<Integer> que){
        while(que.size() > 0){
            int size = que.size();

            while(size-- > 0){
                int removedVertex = que.removeFirst();
                ans.add(removedVertex);

                ArrayList<Edge> list = graph[removedVertex];

                for(Edge edge : list){
                    int v = edge.v;
                    inDegree[v]--;
                    if(inDegree[v] == 0){
                        que.addLast(v);
                    }
                }
            }
        }
    }

    public static void khanTopological(ArrayList<Edge>[] graph){
        int n = graph.length;
        int[] inDegree = new int[n];

        LinkedList<Integer> que = new LinkedList<>();

        for(int i=0; i<n; i++){
            ArrayList<Edge> list = graph[i];
            for(Edge edge : list){
                inDegree[edge.v]++;
            }
        }

        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                que.addLast(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        khanTopologicalSort(graph, inDegree, ans, que);

        if(ans.size() == n){
            System.out.println(ans);
        }else{
            System.out.println("There is a cycle in graph so topological order is not Possible");
        }

    }

    public static void topological_Bfs(int src, boolean[] vis, ArrayList<Edge>[] graph, ArrayList<Integer> ans){
        vis[src] = true;
        ArrayList<Edge> list = graph[src];
        for(Edge edge : list){
            if(vis[edge.v]) continue;
            topological_Bfs(edge.v, vis, graph, ans);
        }
        ans.add(src);
    }
    public static ArrayList<Integer> topological_Sort(ArrayList<Edge>[] graph){
        int n = graph.length;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(graph[i].size() == 0 || vis[i]) continue;
            topological_Bfs(i, vis, graph, ans);
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void display(ArrayList<Integer>[] graph){
        int n = graph.length;
        for(int i=0; i<n; i++){
            if(graph[i].size() == 0) continue;

            System.out.print(i + " -> ");
            ArrayList<Integer> list = graph[i];
            for(Integer edge : list){
                System.out.print("(" + edge + "," + edge + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<k; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            //int w = scn.nextInt();
            addEdge(u, v, 0, graph);
        }
        // khanTopological(graph);
        display(graph);

        topologicalSort_DFS(graph);
    }
}