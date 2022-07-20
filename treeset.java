import java.util.Iterator;
import java.util.TreeSet;
public class treeset{

    public static void main(String args[]) {
       TreeSet<Integer> st = new TreeSet<>();
       st.add(1);
       st.add(5);
       st.add(4);
       st.add(3);
       st.add(2);

       Iterator<Integer> it = st.descendingIterator();

       while(it.hasNext()){
           System.out.print(it.next());
       }
    }
}
