import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class genericTree{
    public static class Node{
        int data;
        ArrayList<Node> children;
        public Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    public static Node createTree(int[] ary){
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i=0; i<ary.length; i++){
            if(ary[i] == -1){
                st.pop(); continue;
            }
            if(st.empty()){
                root = new Node(ary[i]);
                st.push(root);
            }else{
                Node node = new Node(ary[i]);
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }

    public static void display(Node root){
        System.out.println(root.data);

        for(int i=0; i<root.children.size(); i++){
            display(root.children.get(i));
        }
    }

    public static void main(String args[]){
        // Scanner scn = new Scanner(System.in);
        int[] ary = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = createTree(ary);
        display(root);
    }

}