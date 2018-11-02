import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static long solve(int n, long[][] operations) {
        long total=0;
        for(int i=0;i<operations.length;i++){
            total+=operations[i][2]*(operations[i][1]-operations[i][0]+1);
        }
        return total/n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[][] operations = new long[m][3];

        for (int operationsRowItr = 0; operationsRowItr < m; operationsRowItr++) {
            String[] operationsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int operationsColumnItr = 0; operationsColumnItr < 3; operationsColumnItr++) {
                long operationsItem = Long.parseLong(operationsRowItems[operationsColumnItr]);
                operations[operationsRowItr][operationsColumnItr] = operationsItem;
            }
        }

        long result = solve(n, operations);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
