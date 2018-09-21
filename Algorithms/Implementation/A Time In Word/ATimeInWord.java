package DataStructure;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ATimeInWord {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String word[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
            "twenty seven", "twenty eight", "twenty nine"};
        String time = "";
        if (m == 0) {
            time = word[h] + " o' clock";
        } else if (m == 15) {
            time = "quarter past " + word[h];
        } else if (m == 30) {
            time = "half past " + word[h];
        } else if (m == 45) {
            time = "quarter to " + word[h + 1];
        } else if (m < 30) {
            if (m == 1) {
                time = word[m] + " minute past " + word[h];
            } else {
                time = word[m] + " minutes past " + word[h];
            }
        } else {
            time = word[60 - m] + " minutes to " + word[h + 1];
        }
        return time;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int h = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int m = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String result = timeInWords(h, m);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
        System.out.println(timeInWords(1, 1));
    }
}
