package hackerrankcompete;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ThePowerSum {

    // Complete the powerSum function below.
    private static int count=0;
    static int powerSum(int x, int n, int num, double sum) {
        if (sum == x) {
            return 1;
        } else {
            int ans = 0;
            if (sum < x) {
                for (int i = num; i <= Math.pow(x, 1.0 / n); i++) {
                    ans += powerSum(x, n, i + 1, sum + Math.pow(i, n));
                }
            }
            return ans;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N,1,0);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
