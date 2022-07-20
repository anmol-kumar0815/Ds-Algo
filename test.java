public class test extends myArrayList{
    public static void main(String args[]){
        myArrayList list = new myArrayList();
        int j = 2;
        for(int i=1; i<=10; i++){
            list.add(i*j);
        }
        System.out.println(list);
    }
}