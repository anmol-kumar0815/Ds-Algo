import java.util.ArrayList;
public class GraphCode{

    public static class edge{
        int v = 0;
        int w = 0;
        edge(int v, int w){
            this.v = v;
            this.w = w;
        }
        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";

        }
    }
    
    public static int n = 7;
    public static ArrayList<edge>[] graph = new ArrayList[n];
    //Add Edge====================================================
    public static void addEdge(int u, int v, int w){
        graph[u].add(new edge(v,w));
        graph[v].add(new edge(u,w));
    }
    //Display=====================================================
    public static void display(){
        for(int i=0; i<n; i++){
            System.out.print(i+" -> ");
            for(edge e : graph[i]){
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            edge e = graph[u].get(i);
            if (e.v == v)
                return i;
        }
        return -1;
    }
    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);

        // if (idx1 == -1 || idx2 == -1)
        // return;

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    public static void removeVtx(int u) {

        while (graph[u].size() != 0) {
            int n = graph[u].size();
            edge e = graph[u].get(n - 1);
            removeEdge(u, e.v);
        }
    }

    public static boolean hasPath(int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        boolean res = false;
        vis[src] = true;
        for (edge e : graph[src]) {
            if (!vis[e.v])
                res = res || hasPath(e.v, dest, vis);
        }
        return res;
    }

    public static void main(String args[]){
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 10);
        addEdge(4, 5, 10);
        addEdge(4, 6, 10);
        addEdge(5, 6, 10);
        display();
    }
}
