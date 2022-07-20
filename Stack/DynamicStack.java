public class DynamicStack extends stack{
    public DynamicStack(){                //it will call the Default constructor of parent class.
        super();
    }
    public DynamicStack(int capacity){
        super(capacity);                  //it will call the constructor of parent class who's perimeter is int size.
    }
    public DynamicStack(int[] ary){
        super(ary.length);               //it will call the constructor of parent class who's perimeter is int array.
        for(int ele : ary){
            super.pushFinal(ele);
        }
    }
    //dynamic stack implementation
    protected void pushFinal(int data){
        if(super.size == super.capacity){
            int temp[] = super.ary;
            super.initializeVariable(super.capacity * 2);
            for(int ele : temp){
                super.pushFinal(ele);
            }
        }
        super.pushFinal(data);
    }
    public void push(int data){
        pushFinal(data);
    }
}
