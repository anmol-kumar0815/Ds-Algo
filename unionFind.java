import java.util.HashSet;
import java.util.Scanner;
public class unionFind{
    public static class pair{
        int leader;
        int size;
        pair(int leader, int size){
            this.leader = leader;
            this.size = size;
        }
    }

    public static int findLeader(int n, pair[] ary){
        if(n == ary[n].leader){
            return n;
        }
        int leader = findLeader(ary[n].leader, ary);

        return ary[n].leader = leader;
    } 

    public static void union_Sets(int leader1, int leader2, pair[] ary){
        if(ary[leader1].size > ary[leader2].size){
            ary[leader2].leader = leader1;
            ary[leader1].size += ary[leader2].size;
        }else{
            ary[leader1].leader = leader2;
            ary[leader2].size += ary[leader1].size;
        }
    }

    public static void FindComponents(pair[] ary){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<ary.length; i++){
            int leader = ary[i].leader;
            set.add(leader);
        }
        System.out.println(set.size());
    }
    public static void main(String args[]){
        int[][] graph = {{0,3},{0,1},{1,2},{2,3},{2,7},{2,8},{7,8},{3,4},{4,5},{4,6},{5,6},{6,9}};
        pair[] ary = new pair[10];
        //Initilization 
        for(int i=0; i<10; i++){
            ary[i] = new pair(i, 1);
        }

        for(int[] edge : graph){
            int leader1 = findLeader(edge[0], ary);
            int leader2 = findLeader(edge[1], ary);

            if(leader1 != leader2){
                union_Sets(leader1, leader2, ary);
            }
        }


        //FindComponents(ary);

        for(int i=0; i<ary.length; i++){
            System.out.println(i + " ->  Leader = " + ary[i].leader + " size = " + ary[i].size);
        }
    }
}