package Recursion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ArthmeticExpression {
    private static final long VALUE=101L;
    private static int n;
    private static long [] elements;
    private static boolean solve(boolean[][] dp, long sum, int currentElement, List<Character> operators) {
        sum %= VALUE;

        if (currentElement == n && sum == 0) return true;
        else if (currentElement == n) return false;

        if (sum == 0) {
            operators.add('*');
            return solve(dp, sum, currentElement + 1, operators);
        }

        if (dp[(int) sum + 101][currentElement]) {
            return false;
        }

        long moddedElement = (elements[currentElement]) % VALUE;

        operators.add('+');
        if (solve(dp, (sum + moddedElement) % VALUE, currentElement + 1, operators)) {
            return true;
        }
        operators.remove(operators.size() - 1);

        operators.add('-');
        if (solve(dp, (sum - moddedElement) % VALUE, currentElement + 1, operators)) {
            return true;
        }
        operators.remove(operators.size() - 1);

        operators.add('*');
        if (solve(dp, (sum * moddedElement) % VALUE, currentElement + 1, operators)) {
            return true;
        }
        operators.remove(operators.size() - 1);

        dp[(int) sum + 101][currentElement] = true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        n = scn.nextInt();
        elements = new long[n];

        for (int i = 0; i < n; i++) {
            elements[i] = scn.nextLong();
        }

        List<Character> elementsUsed = new ArrayList<>();
        boolean[][] dp = new boolean[202][n];
        solve(dp, elements[0], 1, elementsUsed);

        int i = 1;
        System.out.print(elements[0]);
        for (Character elementUsed : elementsUsed) {
            System.out.print(elementUsed + "" + elements[i++]);
        }

        scn.close();
    }

}

