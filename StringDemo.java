import java.util.Scanner;
public class StringDemo{
	public static Scanner scn = new Scanner(System.in);
	public static void main(String args[]){
		//char ch[] = {'a','n','m','o','l'};
		//String str = new String(ch);
		//System.out.println(str);
		String str = "A";
		String str1 = "Abc";
		System.out.println(str.equalsIgnoreCase(str1));
		String s = str.concat(str1);
		System.out.println(str.compareTo(str1));
		//System.out.println(s);
	}
}