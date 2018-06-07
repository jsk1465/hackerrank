import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the countApplesAndOranges function below.
     */
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges)throws IOException {
        int numApples = 0;
        int numOranges = 0;
        //count number of apples
        for(int distance : apples ){
            int pos = a + distance;
            if(pos>=s && pos<=t)
                numApples++;
        }
        //count number of oranges
        for(int distance : oranges ){
            int pos = b + distance;
            if(pos>=s && pos<=t)
                numOranges++;
        }
        //print the stuff
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        bw.write(String.valueOf(numApples));
        bw.newLine();
        bw.write(String.valueOf(numOranges));
        bw.newLine();
        bw.close();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scan.nextLine().split(" ");

        int s = Integer.parseInt(st[0].trim());

        int t = Integer.parseInt(st[1].trim());

        String[] ab = scan.nextLine().split(" ");

        int a = Integer.parseInt(ab[0].trim());

        int b = Integer.parseInt(ab[1].trim());

        String[] mn = scan.nextLine().split(" ");

        int m = Integer.parseInt(mn[0].trim());

        int n = Integer.parseInt(mn[1].trim());

        int[] apple = new int[m];

        String[] appleItems = scan.nextLine().split(" ");

        for (int appleItr = 0; appleItr < m; appleItr++) {
            int appleItem = Integer.parseInt(appleItems[appleItr].trim());
            apple[appleItr] = appleItem;
        }

        int[] orange = new int[n];

        String[] orangeItems = scan.nextLine().split(" ");

        for (int orangeItr = 0; orangeItr < n; orangeItr++) {
            int orangeItem = Integer.parseInt(orangeItems[orangeItr].trim());
            orange[orangeItr] = orangeItem;
        }
        try{
            countApplesAndOranges(s, t, a, b, apple, orange);
        }
        catch(IOException e){}
    }
}
