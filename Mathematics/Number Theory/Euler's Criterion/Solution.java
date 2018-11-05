import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static long modpow(long base_value, long exponent, long modulus) {
        base_value = base_value % modulus;
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1)
                result = (result * base_value) % modulus;
            base_value = (base_value * base_value) % modulus;
            exponent = exponent / 2;
        }
        return result;
    }

    static String solve(long a, long m) {
        if(a==0)return "YES";
        long modpow = modpow(a, (m - 1) / 2, m);
        return (modpow == 1) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] am = scanner.nextLine().split(" ");

            long a = Long.parseLong(am[0]);

            long m = Long.parseLong(am[1]);

            String result = solve(a, m);

            System.out.println(result);
        }

        scanner.close();
    }
}
