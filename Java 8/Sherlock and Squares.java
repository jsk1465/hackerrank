import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        //for each number in range (a,b)
        int numSquares = 0;
        /*for(int val = a;val<=b;val++){
            //check if is square root
            double root = Math.sqrt(val);
            int intRoot = (int)root;
            double testRoot =(double)intRoot;
            if(root == testRoot)
                numSquares++;
        }
        */
        int sum = 1;
        for(int sq= 3; sum<=b;sq+=2){
            if(sum>=a)
                numSquares++;
            sum+=sq;
        }
        return numSquares;
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
