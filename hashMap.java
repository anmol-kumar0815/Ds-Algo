import java.util.HashMap;
public class hashMap {

    public static void getMyMap(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Anmol",5);
        map.put("rohit",5);
        map.put("saud",4);
        map.put("umang",5);
        map.put("vipin",5);
        map.put("vikash",6);

        //System.out.println(map);
        for(String key : map.keySet()){
            System.out.println(key + " -> " + map.containsKey(key));
        }
    }
    
    public static void getFrequency(String str){
        HashMap<Character,Integer> fre = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            fre.put(str.charAt(i),fre.getOrDefault(str.charAt(i), 0) +1);
            // if(fre.containsKey(str.charAt(i))){
            //     int val = fre.get(str.charAt(i));
            //     fre.put(str.charAt(i), val+1);
            // }else{
            //     fre.put(str.charAt(i) , 1);
            // }
        }
        for(Character key : fre.keySet()){
            System.out.println(key + " -> " + fre.get(key));
        }
    }
    public static void getLargest(String str){
        HashMap<Character, Integer> freq = new HashMap<>();
        char ch;
        int val;
        for(int i=0; i<str.length(); i++){
            ch = str.charAt(i);
            if(freq.containsKey(ch)){
                val = freq.get(ch);
                freq.put(ch,val+1);
            }else{
                freq.put(ch,1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Character key : freq.keySet()){
            if(max < freq.get(key)){
                max = freq.get(key);
            }
        }
        System.out.println(max);
    }

    public static void intersectionOfTwoArrayWithDuplicates(int[] ary1, int[] ary2){

    }

    public static void main(String args[]){
        //getMyMap();
        //getLargest("aaaaajdjdhskihc");
        getFrequency("aaabcdsa");
    }
}
