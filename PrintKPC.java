import java.util.Scanner;
public class PrintKPC {
    public static Scanner scn = new Scanner(System.in);
    public static String codes[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        public static void printkpc(String ques, String ans) {
            if(ques.length() == 0){
                System.out.println(ans);
                return;
            }
            char ch = ques.charAt(0);
            String ros = ques.substring(1);
            String options = codes[ch - '0'];
            for(int i=0; i< options.length(); i++){
                printkpc(ros,ans + options.charAt(i));
            }
        }

        public static void main(String args[]) {
            String str = scn.nextLine();
            printkpc(str,"");
        }
    }