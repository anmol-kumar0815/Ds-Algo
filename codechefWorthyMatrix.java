// An efficient Java program to find
// sum of all subsquares of size k x k
import java.io.*;
import java.util.*;
class codechefWorthyMatrix {
	
// Size of given matrix
//static int n = 5;

// A O(n^2) function to find sum of all
// sub-squares of size k x k in a given
// square matrix of size n x n
static int printSumTricky(int mat[][], int k, int m, int n, int a) {
	double temp,div;
    int count = 0;
	// k must be smaller than or equal to
	// 1: PREPROCESSING
	// To store sums of all strips of size k x 1
	double stripSum[][] = new double[m+1][n+1];

	// Go column by column
	for (int j = 0; j < n; j++) {
		
	// Calculate sum of first k x 1
	// rectangle in this column
	double sum = 0.0;
	for (int i = 0; i < k; i++)
		sum += mat[i][j];
	stripSum[0][j] = sum;

	// Calculate sum of remaining rectangles
	for (int i = 1; i < m - k + 1; i++) {
		sum += (mat[i + k - 1][j] - mat[i - 1][j]);
		stripSum[i][j] = sum;
	}
	}

	// 2: CALCULATE SUM of Sub-Squares
	// using stripSum[][]
	for (int i = 0; i < m - k + 1; i++) {
		
	// Calculate and print sum of first
	// subsquare in this row
	int sum = 0;
	for (int j = 0; j < k; j++)
		sum += stripSum[i][j];
        div = (a+1)*(a+1);
        temp = sum / div;
        if(temp >= k) count++;
	//System.out.print(sum + " ");

	// Calculate sum of remaining squares
	// in current row by removing the
	// leftmost strip of previous sub-square
	// and adding a new strip
	for (int j = 1; j < n - k + 1; j++) {
		sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);
        div = (a+1)*(a+1);
        temp = sum / div;
        if(temp >= k) count++;
		//System.out.print(sum + " ");
	}
	}
    return count;
}

// Driver program to test above function
public static void main(String[] args)
{
    int count,a;
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    while(t-- > 0){
        count = 0;
        int m = scn.nextInt();
        int n = scn.nextInt();
        int k = scn.nextInt();
	    int[][] mat = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = scn.nextInt();
                if(mat[i][j] >= k) count++;
            }
        }
        a = 1;
        while(a < Math.min(m,n)){
            count += printSumTricky(mat,k,m,n,a);
            a++;
        }
        System.out.println(count);
}
}
}

// This code is contributed by vt_m.
