import java.util.Scanner;
import java.util.ArrayList;
public class permutation{

    public static int sum = 0;
    public static void permutation(String que, ArrayList<String> temp, int idx){
        if(temp.size()==3){
            int tempsum = 0;
            for(int i=0; i<3; i++){
                tempsum += Integer.parseInt(temp.get(i));
            }
            if(sum < tempsum){
                sum = tempsum;
                System.out.println(temp);
            }
            return;
        }

        for(int i=idx; i<que.length(); i++){
            if(i == idx) continue;
            String ros = que.substring(0,i) + que.substring(i+1);
            temp.add(que.charAt(i)+"");
            permutation(ros, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String args[]){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        permutation("41283197",new ArrayList<String>(), 0);
        //System.out.println(ans);
        System.out.println(sum);
    }
}