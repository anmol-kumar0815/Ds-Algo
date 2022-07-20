// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class HelloWorld {
    public static int min = Integer.MAX_VALUE;
    public static void findXor(int[] num1, List<Integer> list){
        int xorsum = 0, n = num1.length;
        for(int i=0; i<n; i++){
            xorsum += (num1[i] ^ list.get(i));
        }
        if(xorsum < min)
            min = xorsum;
    }
    public static int minimumXORSum(int[] nums1, int[] nums2) {
        List<Integer> ary = new ArrayList<>();
        Arrays.sort(nums2);
        for(int i=0; i<nums2.length; i++){
            ary.add(nums2[i]);
        }
        permutations(ary,new ArrayList<>(), nums1);
        return min;
    }
    public static void permutations(List<Integer> ary, List<Integer> temp, int[] nums1){
        
        if(ary.size() == 0){
            findXor(nums1, temp);
        }
        
        for(int i=0; i<ary.size(); i++){
            if(i>0 && ary.get(i) == ary.get(i-1))
                continue;
            else{
                temp.add(ary.get(i));
                ary.remove(i);
                
                permutations(ary,temp, nums1);
                
                ary.add(i,temp.get(temp.size()-1));
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String args[]){
        int[] nums1 = {1,0,3};
        int[] nums2 = {5,3,4};
        int ans = minimumXORSum(nums1, nums2);
        System.out.println(ans);
    }
}