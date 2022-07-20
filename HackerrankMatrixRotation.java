import java.util.Scanner;
import java.util.ArrayList;
class HackerrankMatrixRotation{
    public static ArrayList<Integer> getOneD(int minr, int maxr, int minc, int maxc, int[][] ary){
        ArrayList<Integer> v = new ArrayList<>();
        int j;
        for(j=minc; j<=maxc; j++)    v.add(ary[minr][j]);
        for(j=minr+1; j<=maxr; j++)  v.add(ary[j][maxc]);
        for(j=maxc-1; j>=minc; j--)  v.add(ary[maxr][j]);
        for(j=maxr-1; j>minr; j--)   v.add(ary[j][minc]);
        return v;
    }
    public static ArrayList<Integer> rotate(ArrayList<Integer> v, int rot){
        if(rot == v.size()) return v;
        else{
            while(rot-- > 0){
                for(int k=v.size()-1; k>0; k--){
                    int temp = v.get(k);
                    v.set(k,v.get(k-1));
                    v.set(k-1,temp);
                }
            }
            return v;
        }
    }
    public static void insertIntoArray(int minr, int maxr, int minc, int maxc, ArrayList<Integer> rotated){
        int i = 0,j;
        for(j=minc; j<=maxc; j++){
            ary[minr][j] = rotated.get(i);
            i++;
        }   
        for(j=minr+1; j<=maxr; j++){
            ary[j][maxc] = rotated.get(i);
            i++;
        } 
        for(j=maxc-1; j>=minc; j--){
            ary[maxr][j] = rotated.get(i);
            i++;
        } 
        for(j=maxr-1; j>minr; j--){
            ary[j][minc] = rotated.get(i);
            i++;
        } 
    }
    public static Scanner scn = new Scanner(System.in);
    public static int m = scn.nextInt();
    public static int n = scn.nextInt();
    public static int[][] ary = new int[m][n];
    public static void main(String args[]){
        int r = scn.nextInt();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ary[i][j] = scn.nextInt();
            }
        }
        int maxr = m-1, minr = 0, maxc = n-1, minc = 0;
        for(int o=0; o<Math.min(m,n)/2; o++){
            ArrayList<Integer> v = new ArrayList<>();
            v = getOneD(minr,maxr,minc,maxc,ary);
            // System.out.println("One d array is : ");
            // for(int ele : v){
            //     System.out.print(ele + " ");
            // }
            // System.out.println();
            ArrayList<Integer> rotated = new ArrayList<>();
            
            int rot = r % v.size();
            rot = v.size() - rot;              //For anticlockwise rotation
            // if(rot > 0){                       
            //     rot = v.size() - rot;       //Clockwise rotation for +ve rot;
            // }else{
            //     rot *= -1;                  //Anticlockwise rotation for -ve rot;
            // }
            rotated = rotate(v,rot);
            // System.out.println("Rotated one d array is : ");
            // for(int ele : rotated){
            //     System.out.print(ele + " ");
            // }
            // System.out.println();
            insertIntoArray(minr,maxr,minc,maxc,rotated);
            // System.out.println("Inserted array is: ");
            // for(int i=0; i<m; i++){
            //     for(int j=0; j<n; j++){
            //         System.out.print(ary[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            minr++;
            minc++;
            maxr--;
            maxc--;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }
}