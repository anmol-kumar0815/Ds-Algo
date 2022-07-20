public class TreeRevision {
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static void createTree(Node root){
        //Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right.left = new Node(100);
        root.right.right = new Node(60);
        root.left.right.left = new Node(70);
    }
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        int leftsize = size(root.left);
        System.out.println("Hi");
        int rightsize = size(root.right);

        return leftsize + rightsize + 1;
    }
    public static int max(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int leftmax = max(root.left);
        int rightmax = max(root.right);

        return Math.max(root.data, Math.max(leftmax,rightmax));
    }
    public static int height(Node root){
        if(root == null){
            return -1;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        
        return Math.max(leftheight,rightheight) + 1;
    }
    public static void main(String args[]){
        Node root = new Node(5);
        createTree(root);
        int height = height(root);
        System.out.println(height);
    }
}
