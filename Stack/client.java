public class client extends DynamicStack{ 
    public static void main(String args[]) throws Exception{
        //int[] ary = {1,2,3,4,5};
        DynamicStack mystack = new DynamicStack(5);
        for(int i=1; i<10; i++){
            mystack.push(i);
        }
        System.out.println("Stack = " + mystack.display());
       
    }
}