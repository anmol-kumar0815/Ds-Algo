import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.SoundbankResource;
public class Queen{

    public static boolean isSafeToPlaceQueen(boolean boxes[][], int r, int c){
        int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1}};
        int n = boxes.length, m = boxes[0].length;
        for(int d=0; d<dir.length; d++){
            for(int rad = 1; rad < n; rad++){
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(boxes[x][y])
                        return false;
                }else
                    break;
            }
        }
        return true;
    }

    public static int queenCombinations(boolean[][] boxes, int tnq, int idx, String ans){
        if(tnq == 0){
            System.out.println(ans);
            return 1;
        }

        int n = boxes.length, m = boxes[0].length, count = 0;
        for(int i = idx; i < n * m; i++){
            int r = i / m;
            int c = i % m;
            if(isSafeToPlaceQueen(boxes,r,c)){
                boxes[r][c] = true;
                count += queenCombinations(boxes, tnq-1, i + 1, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static void main(String args[]){
        int n=4, m=4, tnq=4;
        boolean[][] boxes = new boolean[n][m];
        System.out.println(queenCombinations(boxes, tnq, 0, ""));
    }
}