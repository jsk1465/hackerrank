import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        String [] exists = new String[queries.length];
        for(int i=0;i<exists.length;i++)
            exists[i]="No";
        for(int i = 0; i<s.length();){
            int next = findNext(s,i);
            int weight = s.charAt(i);
            weight-=96;
            int gap = next - i;
            for(int j = 0;j<queries.length;j++){
                if(queries[j]%weight==0){
                    if(queries[j]/weight<=gap)
                        exists[j]="Yes";
                }
            }
            i=next;
        }
        return exists;
    }
    
    private static int findNext(String s, int index){
        char cur = s.charAt(index);
        int next;
        for(next = index; next<s.length();next++){
            if(s.charAt(next)!=cur)
                break;
        }
        return next;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
