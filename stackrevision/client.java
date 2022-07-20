public class client extends dynamicStack{
    public static void main(String args[]) throws Exception{  
        dynamicStack mystack = new dynamicStack(5);
        for(int i=1; i<=10; i++){
            mystack.push(i);
        }
        mystack.display();
    }
}
