import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoCharaters function below.
    static int twoCharaters(String s) {
        //just in case
        if(s.length()==0)
            return 0;
        //find unique characters 
        String uniqueChar = "";
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(uniqueChar.indexOf(cur)==-1 && cur>=97 && cur<=122)
                uniqueChar+=""+cur;
        }
        int max = 0;
        //find the maximium number of nonconsecutive numbers by removing the characters from the string
        //get one char 
        for(int i = 0;i<uniqueChar.length();i++){
            char char1 = uniqueChar.charAt(i);      //1st character being compared
            
            //get two char
            for(int j = i+1;j<uniqueChar.length();j++){
                int count = 0;                      //number of non consecutive values that are not removed
                char char2 = uniqueChar.charAt(j);  //2nd character being compared
                //compare with whole string 
                char lastChar = ' ';                //keeps track of what is the last character 
                for(int k = 0; k<s.length();k++){
                    char char3 = s.charAt(k);       //gets a character from the INPUT string
                    //make sure it's one of the non deleted chars
                    if(char1==char3 || char2==char3){
                        //make sure it's not consecutive
                        if(char3==lastChar){
                            count = 0;
                            break;
                        }
                        lastChar = char3;               //update last character
                        count++;                        //move on with life
                    }
                }
                if(count > max)         //calculate the maximum value and update likewise
                    max = count;
            }
        }
        return max;
        
        //iterate through and count the ones that aren't there

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = twoCharaters(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
