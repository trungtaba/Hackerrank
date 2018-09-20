import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AbsolutePermutation {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] array = new int[n];
        HashSet<Integer> used = new HashSet<>();
        //Iterate from left and right filling in the array according to the algorithm above
        for (int i = 0; i < n / 2; i++) {
            int leftMost = i + 1;
            int rightMost = n - i;
            //Left most
            if (leftMost - k > 0 && !used.contains(leftMost - k)) {
                array[i] = leftMost - k;
                used.add(leftMost - k);
            } else if (i + 1 + k <= n && !used.contains(leftMost + k)) {
                array[i] = leftMost + k;
                used.add(leftMost + k);
            } else {
                int[] result={-1};
                return result;
            }

            //Right most
            if (rightMost + k <= n && !used.contains(rightMost + k)) {
                array[n - 1 - i] = rightMost + k;
                used.add(rightMost + k);
            } else if (rightMost - k > 0 && !used.contains(rightMost - k)) {
                array[n - 1 - i] = rightMost - k;
                used.add(rightMost - k);
            } else {
                int[] result={-1};
                return result;
            }
        }

        //if it is odd check to see if we have a number for the middle index
        if (n % 2 == 1) {
            int middle = (n / 2) + 1;

            if (!used.contains(middle + k) || !used.contains(middle - k)) {
                if (!used.contains((n / 2) + 1 + k) && middle + k <= n) {
                    array[(n / 2)] = (n / 2) + 1 + k;
                } else if (!used.contains((n / 2) + 1 - k) && middle - k > 0) {
                    array[(n / 2)] = (n / 2) + 1 - k;
                } else {
                    int[] result={-1};
                return result;
                }
            } else {
                int[] result={-1};
                return result;
            }
        }
        return array;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
