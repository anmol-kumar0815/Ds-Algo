import java.util.Scanner;
public class test extends stackUsingLinkedList{
    //Next smaller to its right
    // [5, 2,  6, 3,  0,  1]
    // [2, 0,  3, 0, -1, -1]
    // stack => 2 0

    public static int[] nextSmallerToRight(int[] ary) throws Exception{
        int n = ary.length;
        System.out.println(n);
        int[] ans = new int[n]; 
        stackUsingLinkedList st = new stackUsingLinkedList();
        for(int i = n-1; i>=0; i--){
            if(st.isEmpty()){
                ans[i] = -1; 
                st.push(ary[i]);
            }else{                             //stack => 1
                while(!st.isEmpty()){                  //5 , 2, 6, 3, 0, 1
                    if(st.peek() < ary[i]){            //             -1 -1
                        ans[i] = st.peek();
                        st.push(ary[i]);
                        break;
                    }else{
                        st.pop();
                    }
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                    st.push(ary[i]);
                }
            }
        }
        return ans;
    }
    
    public static void main(String args[]) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] ary = new int[n];
        for(int i=0; i<n; i++){
            ary[i] = scn.nextInt();
        }
        int[] ans = nextSmallerToRight(ary);

        for(int i : ans)
            System.out.print(i + " ");

        // stackUsingLinkedList st = new stackUsingLinkedList();
        // st.push(5);
        // st.push(10);
        // System.out.println(st.size);
        // System.out.println(st.peek());
    }
}