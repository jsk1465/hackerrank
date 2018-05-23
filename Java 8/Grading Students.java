import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int numGrades = 0;
        int []solution = new int[numGrades];
        for(int grade:grades){
            //update the size of the array
            int []holder = solution;
            solution = new int[holder.length+1];
            for(int i=0;i<holder.length;i++){
                solution[i]=holder[i];
            }
            //do the math checker
            int mod = 5-grade%5;
            if(grade>=35 && mod<3)
                solution[solution.length-1] = grade+mod;
            else
                solution[solution.length-1] = grade;
        }
        return solution;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));
            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();
        bw.close();
    }
}
