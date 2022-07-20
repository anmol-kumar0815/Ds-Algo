import java.util.Scanner;
public class josh {
    public static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int data){
            this.val = data;
            this.next = null;
        } 
    }
    public static class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int val){
            this.val = val; this.right = this.left = null;
        }
    }
    public static class pair{
        String path;
        boolean flag;
        pair(String path, boolean flag){
            this.path = path;
            this.flag = flag;
        }
    }
    public static String ans;
    //you are given a binary tree and a linkedlist return the path in which linkedlist exist in the tree
    public static void traverse(TreeNode root, ListNode head, String path){
        if(root.right == null && root.left== null && head.next == null){
            ans = path;
            return;
        }

        if(root.left != null && head.next != null && root.left.val == head.next.val)
            traverse(root.left, head.next, path + "," + "L");
        
        if(root.right!=null && head.next!=null && root.right.val==head.next.val){
            traverse(root.right, head.next, path + "," + "R");
        }
    }
    
    public static ListNode createLL(){
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;

        return root;
    }

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        return root;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        ListNode head = createLL();
        TreeNode root = createTree();
        traverse(root, head, "");
        System.out.println(ans);
    }
}
