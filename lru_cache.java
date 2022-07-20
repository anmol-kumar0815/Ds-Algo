import java.util.HashMap;
public class lru_cache{
    
    public class Node{
        Node pre = null;
        Node next = null;
        int name;
        int state;
        Node(int name, int state){
            this.name = name;
            this.state = state;
            this.pre = null;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public int size = 0;
    public int capacity = 0;

    public HashMap<Integer,Node> map = new HashMap<>();

    public void addLast(int name, int state){
        if(this.size == 0){
            Node node = new Node(name, state);
            this.head = this.tail = node;
            this.size++;
            map.put(name, node);
        }else if(this.size == this.capacity){
            Node node = new Node(name, state);
            map.put(name, node);
            map.remove(head.name);
            this.tail.next = node;
            this.tail.next.pre = this.tail;
            this.tail = node;
            this.tail.next = null;
            this.head = this.head.next;
            this.head.pre = null;

        }else{
            Node node = new Node(name, state);
            map.put(name, node);
            this.size++;
            this.tail.next = node;
            node.pre = this.tail;
            this.tail = node;
        }
    }

    public void makeExistingRecent(int name, int state, Node address){
        if(address == this.head){
            Node deleteNode = this.head;
            this.head.next.pre = null;
            this.head = this.head.next;
            this.tail.next = deleteNode;
            deleteNode.pre = this.tail;
            deleteNode.next = null;
            this.tail = deleteNode;
            this.tail.state = state;
        }else{
            Node deleteNode = address;
            deleteNode.pre.next = deleteNode.next;
            deleteNode.next.pre = deleteNode.pre;
            this.tail.next = deleteNode;
            deleteNode.pre = this.tail;
            deleteNode.next = null;
            this.tail = deleteNode;
            this.tail.state = state;
        }
    }

    public void makeRecent(int name, int state){
        if(map.containsKey(name)){
            Node address = map.get(name);
            if(address == this.tail){
                address.state = state;
            }else{
                makeExistingRecent(name, state, address);
            }
        }else{
            addLast(name, state);
        } 
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int name) {
        if(map.containsKey(name)){
            makeRecent(name, map.get(name).state);
            return map.get(name).state;
        }
        else
            return -1;
    }
    
    public void put(int name, int state) {
        makeRecent(name, state);
    }
}