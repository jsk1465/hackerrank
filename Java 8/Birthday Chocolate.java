import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        // get m values
        if(m>n)
            return 0;
        int total = 0;
        //SUM THE FIRST
        int sum = 0;
        for(int i = 0;i<m;i++)
            sum+=s[i];
        if(sum == d)
            total++;
        for(int i = 0;i<n-m;i++){
            sum+=s[i+m]-s[i];
            if(sum == d)
                total++;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}