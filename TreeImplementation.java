import java.util.Scanner;

import org.graalvm.compiler.nodes.calc.SignedDivNode;

import java.util.ArrayList;
import java.util.LinkedList;
public class TreeImplementation{
    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    public static Node createTree(){
        // Node root = new Node(1);
        // root.left = new Node(7);
        // root.right = new Node(5);
        // root.left.left = new Node(2);
        // root.left.right = new Node(6);
        // root.right.right = new Node(9);
        // root.right.right.left = new Node(4);
        // root.left.right.left = new Node(5);
        // root.left.right.right = new Node(11);
        //Tree 2===============================
        Node root = new Node(50);
        root.left = new Node(25);
        root.right = new Node(75);
        root.left.left = new Node(12);
        root.left.right = new Node(37);
        root.left.right.left = new Node(30);
        root.right.left = new Node(62);
        root.right.left.left = new Node(60);
        return root;
    }
    public static Node removeLeaves(Node node){
        // write your code here
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }
    public static void printSingleChildNodes(Node node, Node parent){
        // write your code here
        if(node == null){
            return;
        }
        if((node.left == null && node.right != null) || (node.left != null && node.right == null)){
            if(node.left != null){
                System.out.println(node.left.data);
            }else{
                System.out.println(node.right.data);
            }
        }
        printSingleChildNodes(node.left,null);
        printSingleChildNodes(node.right,null);
    }
    //Find Path =============================================
    public static ArrayList<Node> findPath(Node root, boolean flag, int val, ArrayList<Node> list){
        if(root == null || flag == true){
            return list;
        }

        if(root.data == val){
            flag = true;
            //System.out.println("true");
            list.add(root);
            return list;
        }
        if(list.size() == 0){
            findPath(root.left, flag, val, list);
        }
        if(list.size() == 0){
            findPath(root.right, flag, val, list);
        }
        
        if(flag == true || list.size() > 0){
            list.add(root);
        }
        return list;
    }
    //Print kth level nodes
    public static void printKLevelsDown(Node root, int k, int level, Node blocker){
        if(root == null || k < 0 || root == blocker){
            return;
        }
        if(k == level){
            System.out.println(root.data);
        }
        printKLevelsDown(root.left, k, level+1, blocker);
        printKLevelsDown(root.right, k, level+1, blocker);
    }
    //Print nodes K distance Away
    public static void printKDistanceNode(Node root, int value, int level){
        ArrayList<Node> path = new ArrayList<>();
        path = findPath(root,false,value,path);
        for(int i=0; i<path.size(); i++){
            printKLevelsDown(path.get(i),level-i, 0, (i==0) ? null : path.get(i-1));
        }
    }
    //Traversal =============================================
    public static ArrayList<Integer> preOrder(Node root, ArrayList<Integer> list){
        if(root == null){
            return list;
        }
        list.add(root.data);
        preOrder(root.left,list);
        preOrder(root.right,list);
        return list;
    }
    public static void InOrder(Node root){
        if(root == null){
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }
    public static void PostOrder(Node root){
        if(root == null){
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }
    //Basic functions =================================================
    public static int size(Node root){  
        if(root == null){
            return 0;
        }
        int left = size(root.left);
        int right = size(root.right);
        
        return left + right + 1;
    }
    public static int min(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int leftmin = min(root.left);
        int rightmin = min(root.right);

        return Math.min(root.data, Math.min(leftmin, rightmin));
    }
    public static int max(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int leftmax = max(root.left);
        int rightmax = max(root.right);

        return Math.max(root.data, Math.max(leftmax,rightmax));
    }
    public static boolean isBST(Node root, boolean flag1, boolean flag2) {
        if(root == null){
            return true;
        }
        int maxdata = max(root.left);
        int mindata = min(root.right);
        
        flag1 = isBST(root.left,flag1,flag2);
        flag2 = isBST(root.right,flag1,flag2);
        if(root.left == null && root.right == null){
            if(flag1 && flag2 && root.data > maxdata && root.data < mindata){
                return true;
            }else{
                return false;
            }
        }else if(root.left == null){
            if(flag1 && flag2 && root.data < root.right.data && root.data > maxdata && root.data < mindata){
                return true;
            }else{
                return false;
            }
        }else if(root.right == null){
            if(flag1 && flag2 && root.data > root.left.data && root.data > maxdata && root.data < mindata){
                return true;
            }else{
                return false;
            }
        }else{
            if(flag1 && flag2 && root.data > root.left.data && root.data < root.right.data && root.data > maxdata && root.data < mindata){
                return true;
            }else{
                return false;
            }
        } 
    }
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return leftsum + rightsum + root.data;
    }
    
    public static int totaltilt = 0;
    
    public static int findtilt(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = findtilt(root.left);
        int rightsum = findtilt(root.right);
        
        totaltilt += Math.abs(leftsum - rightsum);
        
        return leftsum + rightsum + root.data;
    }
    public static int height(Node root){    // size in terms of edge (Default size)
        if(root == null){
            return -1;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return Math.max(leftheight,rightheight) + 1;
    }

    public static int heightInTermsOfNode(Node root) {
        if (root == null)
            return 0;

        int leftHeight = heightInTermsOfNode(root.left);
        int rightHeight = heightInTermsOfNode(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static class ansPair{
        int node;
        int size;
        boolean isBST;
        ansPair(int node, int size, boolean isBST){
            this.node = node;
            this.size = size;
            this.isBST = isBST;
        }
    }
    public static ansPair largestBST(Node root){
        if(root == null){
            ansPair p = new ansPair(0, 0, true);
            return p;
        }
        
        ansPair ans = new ansPair(0, 0, true);
        
        ansPair leftAns = largestBST(root.left);
        ansPair rightAns = largestBST(root.right);
        
        if(leftAns.isBST && rightAns.isBST && root.data > max(root.left) && root.data < min(root.right)){
            ans.node = root.data;
            ans.size = leftAns.size + rightAns.size + 1;
            ans.isBST = true;
        }else{
            if(leftAns.size > rightAns.size){
              ans.node = leftAns.node;
              ans.size = leftAns.size;
              ans.isBST = false;
            }else{
              ans.node = rightAns.node;
              ans.size = rightAns.size;
              ans.isBST = false;
            }
        }
        return ans;
    }
    //Level order traversal using queue
    public static void levelOrder(Node root){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallans = new ArrayList<>();
            while(size-- > 0){
                Node temp = que.removeFirst();
                smallans.add(temp.data);

                if(temp.left != null)
                    que.addLast(temp.left);
                if(temp.right != null)
                    que.addLast(temp.right);
            } 
            ans.add(smallans);                 
        }
        System.out.println(ans);
    }

    //Shadow width of binary tree
    public static void getWidth(Node root, int vl, int[] minMax){
        if(root == null) return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        getWidth(root.left, vl - 1, minMax);
        getWidth(root.right, vl + 1, minMax);
    }

    //vertical order traversal, top view, bottom view for binary tree
    public static class vPair {
        Node node = null;
        int vl = 0;
        vPair(Node node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root) {
        int[] minMax = new int[2];
        getWidth(root, 0, minMax);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=minMax[0]; i<=minMax[1]; i++) 
            ans.add(new ArrayList<>());
        
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, 0 + Math.abs(minMax[0])));
        
        while(que.size()!=0){
            int size = que.size();
            while(size-- > 0){
                vPair pair = que.removeFirst();
                Node node = pair.node;
                int vl = pair.vl;
                ans.get(vl).add(node.data);
                
                if(node.left != null)
                    que.addLast(new vPair(node.left, vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }
        return ans;
    }

    public static ArrayList<Integer> TopView(Node root) {
        int[] minMax = new int[2];
        getWidth(root, 0, minMax);
        ArrayList<ArrayList<Integer>> tempans = new ArrayList<>();
        for(int i=minMax[0]; i<=minMax[1]; i++)
            tempans.add(new ArrayList<>());

        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, 0 + Math.abs(minMax[0])));

        while(que.size()!=0){
            int size = que.size();
            while(size-- > 0){
                vPair pair = que.removeFirst();
                Node node = pair.node;
                int vl = pair.vl;
                
                tempans.get(vl).add(node.data);
                
                if(node.left != null)
                    que.addLast(new vPair(node.left, vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<tempans.size(); i++){
            ans.add(tempans.get(i).get(0));
        }
        return ans;
    }

    public static ArrayList<Integer> BottomView(Node root) {
        int[] minMax = new int[2];
        getWidth(root, 0, minMax);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=minMax[0]; i<=minMax[1]; i++)
            ans.add(null);

        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, 0 + Math.abs(minMax[0])));

        while(que.size()!=0){
            int size = que.size();
            while(size-- > 0){
                vPair pair = que.removeFirst();
                Node node = pair.node;
                int vl = pair.vl;
                
                //ans.set(vl, node.data);
                
                if(node.left != null)
                    que.addLast(new vPair(node.left, vl-1));
                if(node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }
        return ans;
    }
    //Diagonal traversal of tree(GFG)
    public static ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static void helper(Node root, int idx){
        if(root == null) return;
        if(ary.size() > idx){
            ary.get(idx).add(root.data);
        }else{
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.data);
            ary.add(temp);
        }
        helper(root.left, idx + 1);
        helper(root.right, idx);
    }
     public static ArrayList<Integer> diagonal(Node root){
        helper(root, 0);
        for(ArrayList<Integer> temp : ary){
            for(int i : temp){
                ans.add(i);
            }
        }
        return ans;
    }

    //Print the nodes having exactly one child in a Binary tree (GFG)
    public static int singleChild(Node root, int count){
        if(root == null) return count;
        if((root.left == null && root.right!=null) || (root.left != null && root.right==null)){
            System.out.println(root.data);
            count++;
        }
        count = singleChild(root.left, count);
        count = singleChild(root.right, count);

        return count;
    }
    
    public static void main(String args[]){
        Node root = createTree();
        //levelOrder(root);
        int count = singleChild(root, 0);
        if(count == 0) System.out.println(-1);
    }
}