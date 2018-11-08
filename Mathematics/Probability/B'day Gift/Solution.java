
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class Solution {

    // Complete the solve function below.
    static double solve(int[] balls) {
        return Arrays.stream(balls).sum()/2.0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int ballsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] balls = new int[ballsCount];

        for (int ballsItr = 0; ballsItr < ballsCount; ballsItr++) {
            int ballsItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            balls[ballsItr] = ballsItem;
        }

        double result = solve(balls);
        System.out.println(result);

        scanner.close();
    }
}
