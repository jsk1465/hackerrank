import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        //create boolean array
        boolean [] isChosen = new boolean[26];
        for(int i = 0;i<26;i++)
            isChosen[i] = false;
        for(int i = 0;i<s.length();i++){
            int cur = s.charAt(i);
            //if capital
            if(cur<=90 && cur>=65)
                cur-=65;
            //if lower
            else if(cur <= 122 && cur >= 97)
                cur-=97;
            //not letter
            else
                continue;
            isChosen[cur] = true;
        }
        for(boolean x : isChosen){
            if(!x)
                return "not pangram";
        }
        return "pangram";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
