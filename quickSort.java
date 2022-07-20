import java.util.Random;
public class quickSort{
    public static Random rand = new Random();
    public static void swap(int[] ary, int a, int b){
        int temp = ary[a];
        ary[a] = ary[b];
        ary[b] = temp;
    }
    public static int segregate(int[] ary, int sp, int ep, int pivotIdx){
        swap(ary, pivotIdx, ep);
        int p=sp-1, itr = sp;
        while(itr <= ep){
            if(ary[itr] <= ary[ep]){
                p++;
                swap(ary, itr, p);
            }
            itr++;
        }
        return p;
    }
    public static void QuickSort(int[] ary, int si, int ei){
        if(si >= ei){
            return;
        }
        int pivotIdx = rand.nextInt(ei-si+1) + si;              //si for pivot as first index, ei for pivot as last index, (ei+si)/2 for mid as pivot, rand.(ei-si+1)+si for random index
        pivotIdx = segregate(ary, si, ei, pivotIdx);
        QuickSort(ary, si, pivotIdx - 1);
        QuickSort(ary, pivotIdx + 1, ei);
    }
    public static void main(String args[]){
        int[] ary = {1,6,9,3,0,1,5,6,9,7,5,-6,1,-22,-60};
        //System.out.println(ary.length);
        QuickSort(ary, 0, ary.length-1);
        for(int i : ary)
            System.out.print(i + " ");
    }
}