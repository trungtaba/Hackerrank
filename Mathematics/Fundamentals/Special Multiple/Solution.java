import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static long convert(int n) {
        String string = Long.toBinaryString(n);
        Long number = Long.parseLong(string) * 9;
        return number;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] array = new long[8192];
        for (int i = 0; i < array.length; i++) {
            array[i] = convert(i + 1);
        }
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < array.length; i++) {
                if (array[i] % n == 0) {
                    System.out.println(array[i]);
                    break;
                }
            }
        }

        scanner.close();
    }
}
// 9223372036854775807