import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int sumDigit(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n = n / 10;
        }
        sum += n;
        return sum;
    }

    static void printArray(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                array1.add(i);
                array2.add(n / i);
            }
        }

        int best = 0;
        int index1 = -1;
        for (int i = 0; i < array1.size(); i++) {
            if (sumDigit(array1.get(i)) > best) {

                best = sumDigit(array1.get(i));
                index1 = i;
            }
        }
        // System.out.println("Best="+best);
        int index2 = -1;
        for (int i = array2.size() - 1; i >= 0; i--) {
            // System.out.println("Check array2");
            // System.out.println(sumDigit(array2.get(i)));
            if (sumDigit(array2.get(i)) > best) {

                best = sumDigit(array2.get(i));
                // System.out.println("Best="+best);
                index2 = i;
            }
        }

        if (index2 != -1) {
            System.out.println(array2.get(index2));
        } else {
            System.out.println(array1.get(index1));
        }
        // System.out.println(best);
        scanner.close();
    }
}
