import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        //get is AM or PM AND remove from string
        int posM = s.indexOf('M');
        boolean isPM = false;
        if(s.charAt(posM-1)=='P')
            isPM = true;
        String result = s.substring(0,posM-1);
        //if PM add (12+HH)%24 AND insert the value into string
        if(isPM){
            int newTime = Integer.parseInt(result.substring(0,2))+12;
            newTime = newTime%24;
            if(newTime == 0){
                result = "12"+result.substring(2);
            }
            else{
                result = String.valueOf(newTime) + result.substring(2);
            }
                
        }
        else if(result.substring(0,2).equals("12")){
            //check if values are 12
            result = "00" + result.substring(2);
        }
        //return the new string
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
