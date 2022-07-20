import java.util.Scanner;
public class LinkedListImplementation{
    public static class Node{
        Node next;
        int data;
        Node(){
            this.data = -1;
            this.next = null;
        }
    }
    public static class LinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;
        LinkedList(){
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        
        //Add=======================================================================
        void addLast(int value){
            Node temp = new Node();
            temp.data = value;
            temp.next = null;
            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = tail.next;
            }
            size++;
        }
           
        void addFirst(int value){
            Node temp = new Node();
            temp.data = value;
            if(size == 0){
                temp.next = null;
                head = tail = temp;
            }else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void addAt(int idx, int value){
            if(idx < 0 || idx > size){
                System.out.println("Invalid Index passed");
            }else if(idx == 0){
                addFirst(value);
            }else if(idx == size){
                addLast(value);
            }else{
                Node temp = new Node();
                temp.data = value;
                Node frwd = head;
                for(int i=0; i<idx-1; i++){
                    frwd = frwd.next;
                }
                temp.next = frwd.next;
                frwd.next = temp;
                size++;
            }
        }

        //Remove=========================================================================
        void removeFirst(){
            if(size == 0){
                System.out.println("List is already empty can't delete more data");
            }else{
                Node temp = head;
                head = head.next;
                temp.next = null;
                size--;
            }
        }
 
        void removeLast(){
            if(size == 0){
                System.out.println("List is already empty can't delete more data");
            }else if(size == 1){
                head = tail = null;
            }else{
                Node temp = head;
                for(int i=0; i<size-2; i++){
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
        }

        void removeAt(int idx){
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index: Please enter a valid Index");
            }else if(size == 0){
                System.out.println("List is empty: ");
            }else if(idx == 0){
                removeFirst();
            }else if(idx == size - 1){
                removeLast();
            }else{
                Node temp = head;
                for(int i=0; i<idx - 1; i++){
                    temp = temp.next;
                }
                Node frwd = temp.next;
                temp.next = temp.next.next;
                frwd.next = null;
                size--;
            }
        }
        public int size(Node h){
            int size = 0;
            for(Node p=h; p!=null; p=p.next){
                size++;
            }
            return size;
        }
        public Node getNodeAt(int idx) {

            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp;
        }
        //Leetcode Intersection of LinkedList
        public Node intersection(Node h1, Node h2){
            int size1 = size(h1);
            int size2 = size(h2);
            Node p1 = h2, p2 = h2;
            if(size1 > size2){
                int diff = size1 - size2;
                while(diff-- > 0){
                    p1 = p1.next;
                }
            }else if(size2 > size1){
                int diff = size2 - size1;
                while(diff-- > 0){
                    p2 = p2.next;
                }
            }
            while(p1!=null && p2!=null){
                if(p1==p2){
                    return p1;
                }
            }
            return null;
        }
        public void reverseDI(Node root, int i, int j) {
          // write your code here
          if(i > j){
              return;
          }
          reverseDI(root.next, i + 1, j - 1);
          Node first = getNodeAt(i);
          Node second = getNodeAt(j);
          
          int temp = first.data;
          first.data = second.data;
          second.data = temp;
        }
        //Display =======================================================================
        void display(Node head){
            for(; head!=null; head = head.next){
                System.out.print(head.data + " ");
            }
        }
        public Node reverse(Node head){
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
        public Node unFload(Node head){
            if(head == null && head.next == null) return head;
            Node small = new Node();
            Node big = new Node();
            Node smallHead = small, bigHead = big, p = head;
            int i = 0;
            for(; p!=null; p=p.next, i++){
                if(i % 2 == 0){
                    small.next = p;
                    small = p;
                }else{
                    big.next = p;
                    big = p;
                }
            }
            small.next = null;
            big.next = null;
            Node head2 = reverse(bigHead.next);
            small.next = head2;
            return smallHead.next;
        }
        public void callMyFun(){
            Node head = unFload(this.head);
            display(head);    
        }
    }
    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int n = scn.nextInt();
        for(int i=0; i<n; i++){
            int temp = scn.nextInt();
            list.addLast(temp);
        }
        list.callMyFun();
    }
}