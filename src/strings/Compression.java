package strings;

/**
 * Created by anurag on 10/30/14.
 */
public class Compression {
    public String compressString(String s){
        int count = 1;
        String output = "";

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                output = output + s.charAt(i-1) + count;
                count = 0;
            }
            count++;
        }
        output = output + s.charAt(s.length()-1) + count;
        return  output.length() < s.length() ? output : s;
    }

    public static void main(String args[]){
        String s = "aaaaaaaabbcc";

        Compression compression = new Compression();
        System.out.println(compression.compressString(s));
    }
}
