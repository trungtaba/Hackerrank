
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Solution {

    // Complete the solve function below.
    static int[] solve(int[] a) {
        int[]result=new int[a.length+1];
        result[0]=a[0];
        for(int i=1;i<a.length;i++){
            result[i]=(a[i-1]*a[i])/gcd(a[i-1], a[i]);
        }
        result[a.length]=a[a.length-1];
        return result;
    }
    
    static int gcd(int n1, int n2) {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int aCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[aCount];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int aItr = 0; aItr < aCount; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr]);
                a[aItr] = aItem;
            }

            int[] result = solve(a);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
