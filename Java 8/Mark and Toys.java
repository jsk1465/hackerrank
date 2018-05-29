import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        //sort
        //add smallest till it's too big
        int total = 0;
        int numToys = 0;
        int cur;
        int max = 0;
        for(int i = 0; i<prices.length;i++){
            if(prices[i]>max){
                max = prices[i];
            }
        }
        while(numToys<prices.length && total<k){
            int min = prices[0];
            int minIndex = 0;
            for(int j = 1;j<prices.length;j++){
                if(prices[j]<min){
                    min = prices[j];
                    minIndex = j;
                }
            }
            total+=prices[minIndex];
            prices[minIndex] = max;
            numToys++;
            
            
        }
        return numToys-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
