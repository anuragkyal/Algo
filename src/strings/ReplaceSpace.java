package strings;

/**
 * Created by anurag on 10/30/14.
 */
public class ReplaceSpace {
    public String replaceSpace(char[] bufferedString, int trueLength){
        int j = bufferedString.length - 1;
        for(int i=trueLength-1; i>=0; i--){
            if(bufferedString[i] != ' '){
                bufferedString[j--] = bufferedString[i];
            }else {
                bufferedString[j--] = '0';
                bufferedString[j--] = '2';
                bufferedString[j--] = '%';
            }
        }
        return String.valueOf(bufferedString);
    }

    public static void main(String args[]){
        String s = "abc hfg jfh        ";
        char[] sArray = s.toCharArray();

        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(sArray, 11).trim());
    }
}
