package strings;

/**
 * Created by anurag on 10/30/14.
 */
public class RevString {
    public String reverseString(String s){
        char[] sArray = s.toCharArray();
        int actualLength = s.length()-1;
        int j;
        char temp;

        for(int i=0; i<actualLength/2; i++){
            j = actualLength - 1 - i;
            temp = sArray[j];
            sArray[j] = sArray[i];
            sArray[i] = temp;
        }

        return String.valueOf(sArray);
    }

    public static void main(String args[]){
        String s1 = "abcdefg!";
        String s2 = "abcdefgh#";

        RevString revString = new RevString();
        System.out.println(revString.reverseString(s1));
        System.out.println(revString.reverseString(s2));
    }
}
