/*
Trungtaba 30/9/2018
hackkerrank: https://www.hackerrank.com/challenges/fibonacci-modified/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ModifierFibonacci {
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger output = new BigInteger("0");
        BigInteger b1 = new BigInteger(t1+"");
        BigInteger b2 = new BigInteger(t2+"");
        if(n==1) return b1;
        if(n==2) return b2;
        for( int i=2;i<n;i++){
            output=b2.multiply(b2);
            output=output.add(b1);

            b1 = new BigInteger(b2.toString());
            
            b2 = new BigInteger(output.toString());
        }
        return output;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
