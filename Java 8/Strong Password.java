import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumNumber(int n, String password) {
        //RAW DATA
        //String numbers = "0123456789";
        //String lower_case = "abcdefghijklmnopqrstuvwxyz";
        //String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
        //init variables
        int numExtras = 4;
        boolean hasNumber =false;
        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasSpecial=false;
        //check if it needs any of the extra characters
        for(int i = 0;i<password.length();i++){
            char cur = password.charAt(i);
            //check upper
            if(!hasUpper && cur<=90 && cur>=65){
                hasUpper = true;
                numExtras--;
            }
            //checker lower
            else if(!hasLower && cur<=122 && cur>=97){
                hasLower = true;
                numExtras--;
            }
            //check number
            else if(!hasNumber && cur<=57 && cur>=48){
                hasNumber = true;
                numExtras--;
            }
            //check special
            else if(!hasSpecial){
                for(int j = 0; j<special_characters.length();j++){
                    if(special_characters.charAt(j)==cur){
                        hasSpecial = true;
                        numExtras--;
                        break;
                    }
                }
            }
        }
        //check to see if it fits the minimum
        if(n<6){
            return max(6-n,numExtras);
        }
        return numExtras;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
    
    private static int max(int a, int b){
        if(a<b)
            return b;
        return a;
    }
}