import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static String payBack(int size,int[]ar,int itemSkip,int payed){
        int total = 0;
        for(int i = 0; i<size; i++){
            if(i!=itemSkip)
                total += ar[i];
        }
        int shouldPay = total/2;
        int owes = payed - shouldPay;
        if(owes == 0)
            return "Bon Appetit";           
        return "" + owes;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[] ) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //get input
        String[] data = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int numItems = Integer.parseInt(data[0]);
        int itemSkip = Integer.parseInt(data[1]);
        
        int[] ar = new int[numItems];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int payed = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i  = 0; i<numItems; i++){
            int arItem =  Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        String result = payBack(numItems,ar,itemSkip,payed);
        
        // do code
        
        
        //print
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}