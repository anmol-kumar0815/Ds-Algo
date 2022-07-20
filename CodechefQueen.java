/* package codechef; // don't place package name! */

import java.util.*;

import javax.sound.midi.SoundbankResource;

import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodechefQueen
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
	    int t = scn.nextInt();
	    int n,i,temp;
	    while(t-- > 0){
            HashMap<Integer,Integer> map = new HashMap<>();
	        ArrayList<Integer> ary = new ArrayList<>();
	        n = scn.nextInt();
	        for(i=0; i<n; i++){
	            temp = scn.nextInt();
	            map.put(temp,map.getOrDefault(temp,0)+1);
	        }
	        for(int key : map.keySet()){
                System.out.println(key + " -> " + map.get(key));
	            ary.add(map.get(key));
	        }
	        Collections.sort(ary);
            for(i=0; i<ary.size(); i++) System.out.print(ary.get(i) + " ");
            System.out.println();
	        for(i=0; i<ary.size()-1; i++){
	            if(ary.get(i) == ary.get(i+1)) break;
	        }
            System.out.println(i);
	        if(i == ary.size()-1) System.out.println("Yes");
	        else System.out.println("No");
	    }
	}
}
