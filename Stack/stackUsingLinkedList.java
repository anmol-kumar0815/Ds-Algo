public class stackUsingLinkedList{
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    protected  Node head = null;
    protected  Node tail = null;
    protected  int size = 0;
    //Initialise
    stackUsingLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Exceptions
    public void underflow() throws Exception{
        if(this.size == 0)
        throw new Exception("Stack is Empty");
    }
    
    //Basic functions
    public void push(int data){
        Node node = new Node(data);
        if(this.size == 0){
            this.head = this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }
    public int pop() throws Exception{
        underflow();
        int data = this.head.data;
        this.head = this.head.next;
        this.size--;
        return data;
    }
    public boolean isEmpty(){
        if(this.size == 0) return true;
        return false;
    }
    public int peek() throws Exception{
        underflow();
        return this.head.data;
    }
    public int size(){
        return this.size;
    }
}