public class client extends queue {
    public static void main(String args[]) throws Exception{
        queue mylist = new queue();
        for(int i=0; i<10; i++){
            mylist.push(i);
        }
        // mylist.pop();
        // mylist.push(15);
        // mylist.pop();
        // mylist.push(18);
        //System.out.println(mylist);
        System.out.println(mylist);
    }
}
