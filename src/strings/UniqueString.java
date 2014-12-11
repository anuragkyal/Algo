package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anurag on 10/29/14.
 */
public class UniqueString {
    public static boolean isStringUniqueSolution1(String s){
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(Character c: s.toCharArray()){
            if(charMap.get(c) == null){
                charMap.put(c, 1);
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isStringUniqueSolution2(String s){
        char[] sArray = s.toCharArray();
        quickSort(sArray, 0, s.length()-1);

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void quickSort(char[] s, int i, int j){
        if(i>=j){
            return;
        }

        int start = i;
        int end = j;
        int pivot = j;
        char temp;

        while (i<pivot || j>pivot){
            if(s[i] > s[pivot]){
                temp = s[i];
                s[i] = s[pivot];
                s[pivot] = temp;
                pivot = i;
            } else if(i != pivot){
                i++;
            } else if(s[j] < s[pivot]){
                temp = s[j];
                s[j] = s[pivot];
                s[pivot] = temp;
                pivot = j;
            } else if(j != pivot){
                j--;
            }
        }

        quickSort(s, start, pivot-1);
        quickSort(s, pivot+1, end);
    }

    public static void main(String args[]){
        String s = "acbfd";
        System.out.println(isStringUniqueSolution1(s));
        System.out.println(isStringUniqueSolution2(s));
    }
}