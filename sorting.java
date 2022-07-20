import java.util.Scanner;
public class sorting{
    public static int[] intputArray(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  
        int[] ary = new int[n];
        for(int i=0; i<n; i++){
            ary[i] = scn.nextInt();
        }      
        return ary;
    }
    public static void printArray(int[] ary){
        for(int i=0; i<ary.length; i++){
            System.out.print(ary[i] + " ");
        }
    }
    public static void swap(int[] ary, int i, int j){
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }
    public static void bubbleSort(int[] ary){
        int swapCount = 0;
        int n = ary.length;
        for(int i=0; i<n; i++){
            swapCount = 0;
            for(int j=i+1; j<n; j++){
                if(ary[i] > ary[j]){
                    swap(ary, i, j);
                    swapCount++;
                }
            }
            if(swapCount == 0) break;
        }
    }
    public static void selectionSort(int[] ary){
        int n = ary.length, ci;
        for(int i=0; i<n; i++){
            ci = i;
            for(int j=i+1; j<n; j++){
                if(ary[ci] > ary[j]){
                    ci = j;
                }
            }
            swap(ary, ci, i);
        }
    }
    
    public static int[] mergeTwoSortedArray(int[] a, int[] b){
        int[] ans = new int[a.length + b.length];
        int i = 0, j = 0, p = 0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                ans[p++] = a[i++];
            }else{
                ans[p++] = b[j++];
            }
        }

        while(i < a.length){
            ans[p++] = a[i];
            i++;
        }
        while(j < b.length){
            ans[p++] = a[j];
            j++;
        }

        return ans;
    } 

    public static int[] mergeSort(int i, int j, int[] ary){
        if(i == j){
            int[] base = new int[1];
            base[0] = ary[i];
            return base;
        }
        int mid = (i + j) / 2;
        int[] firstSorted = mergeSort(i, mid, ary);
        int[] secondSorted = mergeSort(mid+1, j, ary);

        return mergeTwoSortedArray(firstSorted, secondSorted);
    }

    public static void main(String args[]){
        int[] ary = intputArray();

        //bubbleSort(ary);
        // selectionSort(ary);
        // int [] ans = mergeSort(0, ary.length-1, ary);
        // printArray(ans);
    }
}