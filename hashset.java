/* HashSet contains only unique values.
HashSet contains element in sorted order. 
Time Complexity of HashSet Operations amortize (average or usual case) time complexity for add, remove and look-up (contains method) operation of HashSet takes.
*/

import java.util.Scanner;
import java.util.HashSet;
public class hashset{

    public static void fun(String str){
        if(str.length() == 5) return;
        fun(str + "a");
        System.out.println(str);
    }

    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        HashSet<Integer> map = new HashSet<>();
        map.add(5);
        map.add(6);
        map.add(8);
        map.add(7);
        map.add(6);

        for(int ele : map){
            System.out.println(ele);
        }

        // fun("");
    } 
}