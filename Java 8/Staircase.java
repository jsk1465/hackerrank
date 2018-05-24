import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the staircase function below.
     */
    static void staircase(int n) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String stair = "#";
        for (int i = 0;i < n; i++) {
            /*for(int j = 0;j<i;j++)
                bw.write(stair);
                */
            for(int j = n-1;j>=0;j--){
                if(j>i)
                    bw.write(" ");
                else
                    bw.write(stair);
            }

            bw.newLine();
        }
        bw.newLine();

        bw.close();


    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());
        try{
            staircase(n);
        }
        catch(IOException e){
            
        }
    }
}
