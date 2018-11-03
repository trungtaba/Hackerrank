import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        HashMap<Integer, Long> map = new HashMap<>();
        Long i1 = 0l;
        Long i2 = 1l;
        map.put(1, i1);
        map.put(2, i2);
        for (int i = 3; i < 100; i++) {
            map.put(i, i1 + i2);
            long tmp = i1;
            i1 = i2;
            i2 += tmp;
        }

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            if (map.containsValue(n))
                System.out.println("IsFibo");
            else
                System.out.println("IsNotFibo");
        }

        scanner.close();
    }
}
