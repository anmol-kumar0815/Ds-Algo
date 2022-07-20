public class myArrayList{
    protected int[] ary = null;
    protected int capacity = 0;
    protected int size = 0;

    myArrayList(){
        this.ary = new int[5];
        this.capacity = 5;
        this.size = 0;
    }

    //Exceptions
    public void underFlow(int i) throws Exception{
        if(this.size - 1 < i){
            throw new Exception("Array out of bound");
        }
    }

    public int size(){
        return this.size;
    }

    public int get(int i) throws Exception{
        underFlow(i);
        return this.ary[i];
    }

    public void add(int data){
        if(this.capacity == this.size){
            int[] temp = this.ary;
            this.ary = new int[this.capacity * 2];
            this.capacity = this.capacity * 2;
            this.size = 0;
            for(int i=0; i<temp.length; i++){
                this.ary[this.size++] = temp[i];
            }
                
        }else{
            this.ary[this.size] = data;
            this.size++;
        }
    }

    @Override
    public String toString(){
        System.out.print('[');
        for(int i=0; i<this.size; i++){
            System.out.print(this.ary[i]);
            if(i != this.size - 1)
                System.out.print(", ");
        }
        System.out.println(']');
        return "";
    }
}