/*
trungtaba: 30/9/2018
hackkerrank: https://www.hackerrank.com/challenges/sherlock-and-cost/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndCost {

    // Complete the cost function below.
    static int cost(int[] B) {  
        int n=B.length;
        int A[][]=new int[n][2];
        A[0][0]=0; A[0][1]=0;
        for(int i=0;i<n-1;i++){
            A[i+1][0]=Math.max(A[i][0],A[i][1]+Math.abs(B[i]-1));
            A[i+1][1]=Math.max(A[i][0]+Math.abs(B[i+1]-1),A[i][1]+Math.abs(B[i]-B[i+1]));
        }
        return Math.max(A[n-1][0],A[n-1][1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
