public class pairImplementation{
    public static class pair{
        int first;
        int second;
        pair next;
        pair(int first, int second){
            this.first = first;
            this.second = second;
            this.next = null;
        }
    }
    public static void addLast(int first, int second){
        pair node = new pair(first, second);
        lastnode.next = node;
    }
    public static void main(String args[]){
        pair node = new pair(5,2);
        pair head = node;
        pair frwd = head;
        
    }
}