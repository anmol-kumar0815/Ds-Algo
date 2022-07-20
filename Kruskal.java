//Kruskal algo
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Kruskal{

    public static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
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
        graph[u].add(new Edge(u,v,w));
        //graph[v].add(new Edge(v,u,w));
    }
    public static void dislayGraph(ArrayList[] graph){
        int sum = 0;
        for(int i=0; i<graph.length; i++){
            ArrayList<Edge> list = graph[i];
            for(Edge edge : list){
                System.out.println(i + " ," + edge.v + " -> " + edge.w);
                sum += edge.w;
            }
        }
        System.out.println("Total Weight = " + sum);
    }

    public static void print2D(Integer[][] ary){
        for(int i=0; i<ary.length; i++){
            System.out.println(ary[i][0] + " " + ary[i][1] + " " + ary[i][2]);
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
    public static void unionFind(Integer[][] Edges, int n){
        ArrayList<Edge>[] mstGraph = new ArrayList[n+1];
        for(int i=0; i<=n; i++) mstGraph[i] = new ArrayList<>();

        Pair[] unionSet = new Pair[n+1];
        for(int i=0; i<=n; i++) unionSet[i] = new Pair(i, 1);

        for(Integer ary[] : Edges){
            int u = ary[0], v = ary[1], w = ary[2];

            Pair l1 = findLead(u, unionSet);
            Pair l2 = findLead(v, unionSet);

            if(l1.lead == l2.lead) continue;

            if(l2.size > l1.size){
                l2.size += l1.size;
                l1.lead = l2.lead;
            }else{
                l1.size += l2.size;
                l2.lead = l1.lead;
            }
            addEdge(u, v, w, mstGraph);
        }

        printUnionSet(unionSet);
        System.out.println();
        dislayGraph(mstGraph);
    }

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();     // what can be the largest node
        
        int numberOfEdges = scn.nextInt(); 
        Integer[][] Edges = new Integer[numberOfEdges][3];
        for(int i=0; i<numberOfEdges; i++){
            Edges[i][0] = scn.nextInt();
            Edges[i][1] = scn.nextInt();
            Edges[i][2] = scn.nextInt();
        }

        Arrays.sort(Edges, (a,b) -> {             
            return a[2] - b[2];
        });

        //print2D(Edges);
        unionFind(Edges, n);
    }
}

//Time complexity  = O(ElogE)  E => number of Edges

/* 8
14
7 6 1
8 2 2
6 5 2
0 1 4
2 5 4
8 6 6
2 3 7
7 8 7
0 7 8
1 2 8
3 4 9
5 4 10
1 7 11
3 5 14
*/