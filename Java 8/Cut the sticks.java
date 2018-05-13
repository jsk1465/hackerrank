import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        int curSize = 0;
        int [] result = new int[curSize];
        while(true){
            int numCuts = 0;
            //find the minimum value > 0
            int min = 0;
            for(int itemIter : arr){
                if(itemIter>0){
                    if(min == 0)
                        min = itemIter;
                    if(itemIter<min)
                        min = itemIter;
                }
            }
            //if none are found return
            if (min == 0)
                return result;
            //cut all values that are > minimum value
            for(int i = 0;i<arr.length;i++){
                if(arr[i]>0){
                    numCuts++;
                    arr[i]-=min;
                }
            }
            //add numCuts to return array
            curSize++;
            int []test = result;
            result = new int[curSize];
            for(int i = 0; i<test.length;i++){
                result[i] = test[i];
            }
            result[result.length-1] = numCuts;
            
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
