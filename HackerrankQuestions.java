import java.util.Scanner;
class HackerrankQuestions{
    public static Scanner scn = new Scanner(System.in);

    public static class Node{
        int lead,size;
        Node(int l, int s){
            this.lead = l;
            this.size = s;
        }
    }
    public static Node findLead(int ch, Node[] unionSet){
        if(ch == unionSet[ch].lead) return unionSet[ch];
        Node l = findLead(unionSet[ch].lead, unionSet);
        unionSet[ch].lead = l.lead;
        return l;
    }
    public static int roadsAndLibraries(){
        int t = scn.nextint();
        int n,m,c_lib, c_road;
        while(t-- > 0){
            n = scn.nextInt();
            m = scn.nextInt();
            c_lib = scn.nextInt();
            c_road = scn.nextInt();
            int[][] Edges = new int[m][2];
            for(int i=0; i<m; i++){
                Edges[i][0] = scn.nextInt();
                Edges[i][1] = scn.nextInt();
            }

            //Solving=============================================================
            Node[] unionSet = new Node[n+1];
            for(int i=0; i<=n; i++) unionSet[i] = new Node(i, 1);

            for(int[] ary : Edges){
                int u = ary[0], v = ary[1];

                Node l1 = findLead(u, unionSet);
                Node l2 = findLead(v, unionSet);

                if(l1.lead == l2.lead) continue;

                if(l2.size > l1.size){
                    l1.lead = l2.lead;
                    l2.size += l1.size;
                    l1.size = 0;
                }else{
                    l1.size += l2.size;
                    l2.lead = l1.lead;
                    l2.size = 0;
                }
            }

            int leadCount = 0, totalPublic = 0;
            for(Node node : unionSet){
                if(node.size > 0){
                    leadCount++;
                    totalPublic += node.size - 1;
                }
            }

            int ans1, ans2;
            ans1 = (totalPublic * c_road) + (leadCount * c_lib);
            ans2 = n * c_lib;

            return Math.min(ans1, ans2);
        }
    }
    public static void main(String args[]){

    }
}