public class queue{
    protected int[] ary = null;
    protected int size = 0;
    protected int capacity = 0;
    protected int front = 0;
    protected int back = 0;

    protected void initializeVariable(int capacity){
        this.ary = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.front = 0;
        this.back = 0;
    }
    //Constructor==========================================================
    public queue(){
        initializeVariable(10);
    }
    public queue(int size){
        initializeVariable(size);
    }
    //Exceptions===========================================================
    public void underFlow() throws Exception{
        if(this.size == 0)
           throw new Exception("Queue is Empty");
    }
    public void overFlow() throws Exception{
        if(this.size == this.capacity)
            throw new Exception("Queue is Full");
    }
    //Basic Functions=======================================================
    public int size(){
        return this.size;
    }
    public int front() throws Exception{
        underFlow();
        return this.ary[this.front];
    }
    protected void push_Final(int data){
        this.ary[this.back] = data;
        this.size++;
        this.back = (this.back + 1) % this.capacity;
    }
    public void push(int data) throws Exception{
        overFlow();
        push_Final(data);
    }
    protected void pop_Final(){
        this.ary[this.front] = 0;
        this.size--;
        this.front = (this.front + 1) % this.capacity;
    }
    public void pop() throws Exception{
        underFlow();
        pop_Final();
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0; i<this.size; i++){
            str.append(this.ary[i]);
            if(i!=this.size-1)
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
    public String display(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i=0; i<this.size; i++){
            str.append(this.ary[i]);
            if(i!=this.size-1)
                str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}