import java.util.Scanner;
import java.util.ArrayList;
public class tree001{
    public class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    //Traversal of tree
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data + " ");
         
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public static void main(String args[]){
 
    }
}