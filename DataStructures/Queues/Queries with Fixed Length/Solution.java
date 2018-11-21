
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/queries-with-fixed-length/problem

public class Solution {

    private static long solve(int[] numbers, int d, int N) {
        Queue<Integer> window = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < d; i++) {
            int current = numbers[i];
            window.add(current);
            if (current > max)
                max = current;
        }

        if (max < min)
            min = max;

        for (int i = 1; i <= N - d; i++) {
            int numToAdd = numbers[i + d - 1];
            window.add(numToAdd);
            if (numToAdd >= max)
                max = numToAdd;

            if (window.remove() == max) {
                max = Collections.max(window);
            }

            if (max < min)
                min = max;
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        for (int queriesItr = 0; queriesItr < q; queriesItr++) {
            int queriesItem = scanner.nextInt();
            System.out.print(solve(arr, queriesItem, n));
            if (queriesItr != q-1) {
                System.out.println("");
            }
        }

        scanner.close();
    }
}
