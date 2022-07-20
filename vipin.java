import java.util.Scanner;
public class vipin{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static class ListNode{
        int data = 0;
        ListNode next = null;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node createTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        return root;
    }
    public static ListNode createLinkedList(){
        ListNode head = new ListNode(8);
        ListNode headNext = new ListNode(5);
        ListNode headNextNext = new ListNode(2);
        ListNode headNextNextNext = new ListNode(1);

        head.next = headNext;
        headNext.next = headNextNext;
        headNextNext.next = headNextNextNext;

        return head;
    }

    //Solving==================================================================================
    public static class pair{
        int data;
        Character dir;
        public pair(int data, Character dir){
            this.data = data;
            this.dir = dir;
        }
    }
    public static ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null) return null;
        Node pre = null, curr = head, frwd;
        while(curr != null){
            frwd = curr.next;
            curr.next = pre;
            pre = curr;
            curr = frwd;
        }
        return pre;
    }

    public List<String> anslist = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root.left==null && root.right==null)
            anslist.add(root.val+"");
        else
            helper(root, "");
        return anslist;
    }
    public List<String> helper(Character call, TreeNode root, String ans){
        if(root == null) return anslist;
        
        if(root.left == null && root.right == null){
            if(ans.length() > 0)
                ans = ans+"->"+root.val;
            else
                ans += root.val;
            anslist.add(ans);
            return anslist;
        }
        if(ans.length() > 0)
            ans = ans+"->"+root.val;
        else
            ans += root.val;
        helper('L',root.left, ans);
        helper('R',root.right,ans);
        return anslist;
    }

    public static void solve(Node root, ListNode head){
        head = reverseLinkedList(head);
        List<pair> = new ArrayList<>();
        traverse(root, head);
    }

    public static void main(String args[]){
        Node root = createTree();
        ListNode head = createLinkedList();

        //Solving start
        
    }
}