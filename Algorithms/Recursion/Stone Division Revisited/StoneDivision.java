package Recursion;

import java.util.HashMap;
import java.util.Scanner;

public class StoneDivision {

    private static long solve(long n, long[] S, HashMap<Long, Long> dp) {

        if (n == 0 || n == 1) {
            return 0;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long max = 0;

        for (long s : S) {
            long sum = 0;
            if (n % s != 0 || n == s) {
                continue;
            }

            long numberOfPiles = n / s;
            sum += solve(s, S, dp) * numberOfPiles;
            sum += 1;
            max = Math.max(max, sum);
        }

        dp.put(n, max);

        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int queries = scn.nextInt();
        for (int i = 0; i < queries; i++) {
            long n = scn.nextLong();
            int m = scn.nextInt();

            long[] S = new long[m];

            for (int j = 0; j < m; j++) {
                S[j] = scn.nextLong();
            }

            System.out.println(solve(n, S, new HashMap<>()));
        }
        scn.close();
    }
}
