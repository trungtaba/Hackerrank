import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int gcd(int n1, int n2) {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
    static String solve(int a, int b, int c) {
        if(c<=a || c<=b){
            int tmp = gcd(a, b);
            if (c % tmp == 0)
                return "YES";
            return "NO";
        }else{
            return "NO";
        }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] abc = scanner.nextLine().split(" ");

            int a = Integer.parseInt(abc[0]);

            int b = Integer.parseInt(abc[1]);

            int c = Integer.parseInt(abc[2]);

            String result = solve(a, b, c);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
