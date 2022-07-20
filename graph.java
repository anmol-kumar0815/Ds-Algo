import java.util.ArrayList;
import java.util.Scanner;
public class graph{
    public static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    public static void addEdge(int u, int v, int w, ArrayList<Edge>[] graph){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }
    public static void display(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            ArrayList<Edge> list = graph[i];
            if(list.size() == 0) continue;
            System.out.print(i + " -> ");
            for(Edge edge : list){
                System.out.print(edge.v + " ");
            }
            System.out.println();
        }
    }
    public static void removeEdge(int u, int v, ArrayList<Edge>[] graph){
        ArrayList<Edge> list = graph[u];
        for(int i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            if(edge.v == v){
                list.remove(i);
            }
        }
        list = graph[v];
        for(int i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            if(edge.v == u){
                list.remove(i);
            }
        }
    }
    public static boolean isEdge(int u, int v, ArrayList<Edge>[] graph){
        ArrayList<Edge> list = graph[u];
        int i;
        for(i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            if(edge.v == v){
                break;
            }
        }
        if(i == list.size()) return false;
        list = graph[v];
        for(i=0; i<list.size(); i++){
            Edge edge = list.get(i);
            if(edge.v == u){
                return true;
            }
        }
        return false;
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
        display(graph);
        // removeEdge(0,1,graph);
        // System.out.println();
        // display(graph);
        System.out.println(isEdge(2,5,graph));
    }
}