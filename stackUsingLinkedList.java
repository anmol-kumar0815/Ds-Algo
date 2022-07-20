import java.util.LinkedList;

public class stackUsingLinkedList {
    protected LinkedList<Integer> ll  = new LinkedList();

    public boolean isEmpty(){
        return (ll.size() == 0) ? true : false;
    }

    public int size(){
        return ll.size();
    }

    public void push(int data){
        ll.addLast(data);
    }

    public void pop(){
        ll.removeLast();
    }
    public int top(){
        ll.getLast();
    }
}
