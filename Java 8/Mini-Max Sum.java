import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the miniMaxSum function below.
     */
    static void miniMaxSum(int[] arr) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int length = arr.length;
        Long min=0L,max=0L;
        if(length!=0){
            for(int i = 0; i <length;i++){
                Long sum = 0L;
                for(int j = 0; j <length;j++){
                    if(i!=j)
                        sum += arr[j];
                }
                if(i==0){
                    max = sum;
                    min = sum;
                }
                else if(sum > max)
                    max = sum;
                else if(sum<min)
                    min = sum;
            }
        }
        bw.write(String.valueOf(min));
        bw.write(" ");
        bw.write(String.valueOf(max));
        bw.newLine();

        bw.close();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }
        try{
            miniMaxSum(arr);
        }
        catch(IOException e){}
    }
}
