import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int sumDigit(int a) {
        int sum = 0;
        while (a >= 10) {
            sum += a % 10;
            a /= 10;
        }
        sum += a;
        return sum;
    }

    static String canConstruct(int[] a) {
        int sumDigit = 0;
        for (int i = 0; i < a.length; i++) {
            sumDigit += sumDigit(a[i]);
        }

        if (sumDigit % 3 == 0) {
            return "Yes";
        } else {
            return "No";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = canConstruct(a);

            System.out.println(result);
        }

        scanner.close();
    }
}
