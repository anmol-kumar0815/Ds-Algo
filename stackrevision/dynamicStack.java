public class dynamicStack extends stack{
    public dynamicStack(){
        super();
    }
    public dynamicStack(int capacity){
        super(capacity);
    }
    public dynamicStack(int[] ary){
        super(ary.length);
        for(int ele : ary){
            super.pushFinal(ele);
        }
    }
    protected void pushFinal(int data){
        if(super.size == super.capacity){
            int[] temp = super.ary;
            super.initalizeVariable(super.capacity * 2);
            for(int ele : temp){
                super.pushFinal(ele);
            }
        }
        super.pushFinal(data);
    }
    public void push(int data){
        this.pushFinal(data);
    }
}
