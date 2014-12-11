package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anurag on 10/30/14.
 */
public class IsPermutation {
    public boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(char c: s1Array){
            if(charMap.get(c) == null){
                charMap.put(c, 1);
            }else{
                charMap.put(c, charMap.get(c)+1);
            }
        }

        for(char c: s2Array){
            if(charMap.get(c) == null){
                return false;
            }else{
                charMap.put(c, charMap.get(c)-1);
            }
        }

        for(char c: charMap.keySet()){
            if(charMap.get(c) != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        String s1 = "abcdefg";
        String s2 = "bacfdge";
        String s3 = "abcdefx";

        IsPermutation isPermutation = new IsPermutation();
        System.out.println(isPermutation.isPermutation(s1, s2));
        System.out.println(isPermutation.isPermutation(s1, s3));
    }
}
