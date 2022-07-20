import java.util.*;
import java.lang.*;
import java.io.*;
public class codechefBinaryStringMax{
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static int convertIntoDecimal(String str){
        int res = 0,i=0;
        int j = str.length()-1;
        while(i < str.length()){
            int rem = Character.getNumericValue(str.charAt(j--));
            res = rem * (int)Math.pow(2,i) + res;
            i++;
        }
        return res;
    }
    public static void getSubSequence(String que, String ans){
        if(que.length() == 0){
            if(ans.length() == 0) return;
            int temp = convertIntoDecimal(ans);
            list.add(temp);
            return;
        }
        
        char ch = que.charAt(0);
        String ros = que.substring(1);
        
        getSubSequence(ros, ans + ch);
        getSubSequence(ros, ans);
        
    }
    public static int getMyAns(){
        int i;
        for(i=0; i<list.size()-1; i++){
            if(list.get(i+1) - list.get(i) > 1) return list.get(i) + 1;
        }
        return list.get(i)+1;
    }
    public static int convertIntoBinary(int n){
        int res=0,rem,pow=1;
        while(n!=0)
        {
            rem = n % 2;
            n = n/2;
            res = rem * pow + res;
            pow = pow * 10;
        }
        return res;
    }
	public static void main (String[] args)
	{
	    Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int ans,finalAns;
		scn.nextInt();
		String str;
		while(t-- > 0){
		    str = scn.next();
		    getSubSequence(str,"");
		    Collections.sort(list);
		    ans = getMyAns();
		    finalAns = convertIntoBinary(ans);
		    System.out.println(finalAns);
		}
	}
}

//