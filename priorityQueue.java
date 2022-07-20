//PriorityQueue automatically sort the array in nlogn time
import java.util.Iterator;
import java.util.PriorityQueue;
public class priorityQueue{
    public static void minpq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //By Default min pq
        for(int i=0; i<=10; i++){
            pq.add(i);
        }

        for(Integer ele : pq){
            System.out.print(ele + " ");
        }
    } 

    public static void maxpq(){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{      //this property is known as lamda function 
            return a - b; // By Default
            // return b - a; //Reverse of default
        });
        for(int i=0; i<=10; i++){
            pq.add(i);
        }

        Iterator itr = pq.iterator();
        // while(itr.hasNext()){
        //     System.out.print(itr.next() + " ");
        // }

        for(; itr.hasNext()==true;){
            System.out.println(itr.next());
        }
    }

    public static void main(String args[]){
        // minpq();
        System.out.println();
        maxpq();
    }
}