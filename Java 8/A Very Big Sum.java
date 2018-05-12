import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the aVeryBigSum function below.
     */
    static long aVeryBigSum(int n, long[] ar) {
        long sum=0L;
        long maxItem = 10000000000L;
        long minItem = 0L;
        int maxSize = 10;
        int minSize = 0;
        if(n<minSize||n>maxSize)
            return -1;
        for(int i=0;i<n;i++){
            long arItem = ar[i];
            if(arItem<minItem||arItem>maxItem)
                return -2;
            sum+=arItem;
        }
        return sum;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        long[] ar = new long[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            long arItem = Long.parseLong(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        long result = aVeryBigSum(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}
