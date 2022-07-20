import java.util.ArrayList;
public class stack {
    protected int ary[] = null;
    protected int capacity = 0;
    protected int tos = -1;      //tos = top of the stack its just a pointer which point top of stack
    protected int size = 0;
    
    //Initialize
    protected void initializeVariable(int capacity){
        this.size = 0;
        this.tos = -1;
        this.capacity = capacity;
        this.ary = new int[this.capacity];
    }
    //Constructor==============================
    public stack(){
        initializeVariable(10);
    }
    public stack(int size){
        initializeVariable(size);
    }
    //Exceptions===============================
    private void overFlow() throws Exception {
        if(this.size == this.capacity){
            throw new Exception("StackIsFull");
        }
    }
    private void underFlow() throws Exception{
        if(this.size == 0){
            throw new Exception("StackIsEmpty");
        }
    }
    //Basic functions==========================
    public int size(){
        return this.size;
    }


    public boolean isEmpty(){
        return (this.size == 0) ? true : false;
    }

    //Push===============
    protected void pushFinal(int data){
        this.ary[++this.tos] = data;
        this.size++;
    } 
    public void push(int data) throws Exception{
        overFlow();
        pushFinal(data);
    }
    
    //pop=================
    protected int popFinal(){
        int temp = this.ary[this.tos];
        this.ary[this.tos] = 0;
        this.tos--;
        this.size--;
        return temp;
    }
    public int pop() throws Exception{
        underFlow();
        return popFinal();
    }
    
    //Display stack
    protected ArrayList<Integer> display(){
        int p = this.tos;
        ArrayList<Integer> dis = new ArrayList<>();
        while(p >= 0){
            dis.add(this.ary[p]);
            p--;
        }
        return dis;
    }

    //top=================
    protected int top() throws Exception{
        underFlow();
        return this.ary[this.tos];
    }
}
