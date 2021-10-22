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
    
    public static void main(String args[]){
        int[] ary = intputArray();

        //bubbleSort(ary);
        selectionSort(ary);
        printArray(ary);
    }
}