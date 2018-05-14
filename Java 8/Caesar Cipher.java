import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        String result = "";
        for(int i = 0; i<s.length();i++){
            //check if it's capital
            char cur = s.charAt(i);
            if(cur>=65 && cur <= 90){
                int test = cur;
                test-=65;
                test = (test+k)%26;
                test +=65;
                cur = (char)test;
            }
            else if(cur >= 97 && cur <= 122){
                int test = cur;
                test-=97;
                test = (test+k)%26;
                test+=97;
                cur = (char)test;
            } 
            result+=""+cur;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
