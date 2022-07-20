public class Abhishek{
    public static void main(String args[]){
        String String1 = "Creative", String2 = "Reactive";
        char ch1 = String2.charAt(0) - 'A' + 'a';
        char ch2 = String1.charAt(0) - 'A' + 'a';

        char str1[] = String1.toCharArray();
        char str2[] = String2.toCharArray();

        str1[0] = ch1; str2[0] = ch2;

        if(str1.length != str2.length) System.out.println(0);
        for(int i=0; i<str1.length; i++){
            if(str1[i] != str2[i]){
                System.out.println(0);
                break;
            }
        }
        if(i == str1.length) System.out.println(1);
    }
}