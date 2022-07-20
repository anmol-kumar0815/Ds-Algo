public class stack {
    protected int[] ary = null;
    protected int size = 0;
    protected int capacity = 0;
    protected int tos = -1;

    //initalize variable==================
    protected void initalizeVariable(int capacity){
        this.capacity = capacity;
        this.ary = new int[this.capacity];
        size = 0;
        tos = -1;
    }

    //Constructor=======================
    public stack(){
        initalizeVariable(10);
    }
    public stack(int capacity){
        initalizeVariable(capacity);
    }

    //Exceptions=======================
    public void underFlow() throws Exception{
        if(this.tos == -1){
            throw new Exception("StackIsEmpty");
        }
    }
    //overflow==========================
    public void overFlow() throws Exception{
        if(this.size == this.capacity){
            throw new Exception("StackIsFull");
        }
    }

    //Basic functions
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return (this.size==0) ? true : false;
    }
    public int peek() throws Exception{
        underFlow();
        return this.ary[this.tos];
    }
    
    protected void pushFinal(int data){
        this.ary[++this.tos] = data;
        this.size++;
    }
    public void push(int data) throws Exception{
        overFlow();
        pushFinal(data);
    }
    
    protected void popFinal(){
        this.ary[this.tos] = 0;
        this.size--;
        this.tos--;
    }
    public void pop() throws Exception{
        underFlow();
        popFinal();
    }

    //Display
    public void display(){
        int p = this.tos;
        for(; p>=0; p--){
            System.out.print(this.ary[p] + " ");
        }
    }
}
