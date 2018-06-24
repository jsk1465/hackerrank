import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr)throws IOException{
        //initialize values
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int negative=0;     //number of negative
        int positive = 0;   //number of positive
        int zero=0;         //number of zeros
        int numOf = 0;      //number of numbers
        
        //compute
        for(int arItem : arr){
            if(arItem>0)
                positive++;
            else if(arItem<0)
                negative++;
            else
                zero++;
            numOf++;
        }
        
        //output
        float []result = new float[3];
        if(numOf!=0){
            result[0] = (float)positive/numOf;
            result[1] = (float)negative/numOf;
            result[2] = (float)zero/numOf;
        }
        else{
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
        }
        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.newLine();
            }
        }
        bw.newLine();

        bw.close();
        

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }
        try{
            plusMinus(arr);
        }
        catch(IOException x){
            
        }
    }
}
