import java.util.Scanner;
public class DoublyLinkedListImplementation{
    public static class Node{
        int data;
        Node pre;
        Node next;
        Node(int data){
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }
    public static class DoublyLinkedList{
        protected int size = 0;
        protected Node head = null, tail = null;
        DoublyLinkedList(){
            this.size = 0;
            this.head = null;
            this.tail = null;
        }
        //Functions==================================================

        //Add==============================================================
        protected void addFirst(int data){
            Node node = new Node(data);
            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                node.next = this.head;
                this.head.pre = node;
                this.head = node;
            }
            this.size++;
        }
        protected void addLast(int data){
            Node node = new Node(data);
            if(this.size == 0){
                this.head = this.tail = node;
            }else{
                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;
            }
            this.size++;
        }
        protected void addAt(int idx, int data){
            if(idx < 0 || idx > this.size) {
                System.out.println("Invalid Index");
                return;
            }
            if(idx == 0){
                addFirst(data);
            }else if(idx == this.size){
                addLast(data);
            }else{
                Node node = new Node(data);
                Node p = this.head, frwd;
                for(int i=0; i<idx-1; i++)
                    p = p.next;
                frwd = p.next;
                p.next = node;
                node.pre = p;
                node.next = frwd;
                frwd.pre = node;
                this.size++;
            }
        }
        //Remove=================================================================
        protected int removeFirst(){
            if(this.size == 0){
                System.out.println("LinkedList is Empty");
                return -1;
            } 
            int data = this.head.data;
            Node head = this.head;
            this.head = this.head.next;
            head.next = null;
            this.size--;
            return data;
        }
        protected int removeLast(){
            if(this.size == 0){
                System.out.println("LinkedList is Empty");
                return -1;
            }
            int data = this.tail.data;
            Node p = this.head;
            while(p.next.next != null) p = p.next;
            p.next = null;
            this.tail = p;
            this.size--;
            return data;
        }
        protected int removeAt(int idx){
            if(idx < 0 || idx >= this.size) {
                System.out.println("Invalid Index");
                return -1;
            }
            if(idx == 0){
                return removeFirst();
            }else if(idx == this.size-1){
                return removeLast();
            }else{
                Node p = this.head, frwd;
                for(int i=0; i<idx-1; i++)
                    p = p.next;
                int data = p.next.data;
                frwd = p.next.next;
                p.next = frwd;
                frwd.pre = p;
                this.size--;
                return data;
            }
        }

        //GetAt==============================================================
        protected int getFirst(){
            if(this.size == 0){
                System.out.println("LinkedList is Empty");
                return -1;
            }
            return this.head.data;
        }
        protected int getLast(){
            if(this.size == 0){
                System.out.println("LinkedList is Empty");
                return -1;
            }
            return this.tail.data;
        }
        protected int getAt(int idx){
            if(idx < 0 || idx >= this.size){
                System.out.println("Invalid Index");
                return -1;
            }
            if(idx == 0){
                return getFirst();
            }else if(idx == this.size-1){
                return getLast();
            }else{
                Node p = this.head;
                for(int i=0; i<idx; i++){
                    p = p.next;
                }
                return p.data;
            }
        }
        //Display===========================================================
        protected void display(){
            Node p = this.head;
            while(p != null){
                System.out.print(p.data + " ");
                p = p.next;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList list1 = new DoublyLinkedList();
        int n = scn.nextInt();
        for(int i=0; i<n; i++){
            int data = scn.nextInt();
            list1.addLast(data);
        }
        list1.display();
    }
}