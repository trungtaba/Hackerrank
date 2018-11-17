import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum=0;
        int tempSum=0;
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                tempSum = 0;
                // locate the starting index of each hour glass to work
                if (arr_i < 4 && arr_j < 4) {
                    // create temp sum of current hour glass
                    int tempI = arr_i;
                    int tempJ = arr_j;
                    tempSum += arr[tempI][tempJ];
                    tempJ++;
                    tempSum += arr[tempI][tempJ];
                    tempJ++;
                    tempSum += arr[tempI][tempJ];
                    tempI++;
                    tempJ--;
                    tempSum += arr[tempI][tempJ];
                    tempI++;
                    tempJ--;
                    tempSum += arr[tempI][tempJ];
                    tempJ++;
                    tempSum += arr[tempI][tempJ];
                    tempJ++;
                    tempSum += arr[tempI][tempJ];
                    if (arr_i == 0 && arr_j == 0)
                        maxSum = tempSum;
                    else if (tempSum > maxSum) {
                        maxSum = tempSum;
                    }
                }
            }
        }
        return maxSum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
