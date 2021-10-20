//Kruskal algo
import java.util.Scanner;
import java.util.ArrayList;
public class Kruskal{

    public static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static class Pair{
        int lead, size;
        public Pair(int lead, int size){
            this.lead = lead;
            this.size = size;
        }
    }
    public static void addEdge(int u, int v, int w, ArrayList[] graph){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }
    public static void dislayGraph(ArrayList[] graph){
        for(int i=0; i<graph.length; i++){
            ArrayList<Edge> list = graph[i];
            for(Edge edge : list){
                System.out.println(i + " ," + edge.v + " -> " + edge.w);
            }
        }
    }

    public static void printUnionSet(Pair[] unionSet){
        for(int i=0; i<unionSet.length; i++){
            System.out.println(i + " lead -> " + unionSet[i].lead + " size -> " + unionSet[i].size);
        }
    }

    public static Pair findLead(int ch, Pair[] unionSet){
        if(ch == unionSet[ch].lead) return unionSet[ch];
        Pair L = findLead(unionSet[ch].lead, unionSet);
        unionSet[ch].lead = L.lead;
        return L;
    }
    public static void unionFind(ArrayList[] graph){
        int n = graph.length;
        Pair[] unionSet = new Pair[n];
        for(int i=0; i<n; i++) unionSet[i] = new Pair(i, 1);

        for(int i=0; i<n; i++){
            ArrayList<Edge> list = graph[i];
            for(Edge edge : list){
                Pair l1 = findLead(i, unionSet);
                Pair l2 = findLead(edge.v, unionSet);

                if(l1.lead == l2.lead) continue;

                if(l2.size > l1.size){
                    l2.size += l1.size;
                    l1.lead = l2.lead;
                }else{
                    l1.size += l2.size;
                    l2.lead = l1.lead;
                }
            }
        }

        printUnionSet(unionSet);
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) graph[i] = new ArrayList<>();
        int numberOfEdges = scn.nextInt();
        for(int i=0; i<numberOfEdges; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int w = scn.nextInt();

            addEdge(u,v,w, graph);
        }
        //dislayGraph(graph);
        unionFind(graph);
    }
}