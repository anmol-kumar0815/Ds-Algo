public class advanceRecursion{
    public static int subsetWithEqualSum(int[] ary, int sum1, String set1, int sum2, String set2, int idx){
        if(ary.length == idx){
            if(sum1 == sum2){
                System.out.println(set1 +" = "+set2);
                return 1;
            }
            return 0;
        }
        int count = 0;
        count += subsetWithEqualSum(ary, sum1+ary[idx], set1+ary[idx]+" ", sum2, set2, idx+1);
        count += subsetWithEqualSum(ary, sum1, set1, sum2+ary[idx], set2+ary[idx]+" ", idx+1);
        return count;
    }
    public static void main(String args[]){
        int[] ary = {10,20,30,40,50,60,70,80};
        System.out.println(subsetWithEqualSum(ary, 0, "", 0, "", 0));
    }
}