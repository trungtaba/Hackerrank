package  hackerrankcompete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;


public class RecursiveDigitSum {

    public static BigInteger sum_n_big(String n) {
        BigInteger sd = BigInteger.valueOf(0);
        for (int i = 0; i < n.length(); i++) {
            sd = sd.add(
                BigInteger.valueOf(
                    Character.getNumericValue(n.charAt(i))
                )
            );
        }
        return sd;
    }

    public static BigInteger super_digit(String n) {
        if (n.length() == 1) { return BigInteger.valueOf(Character.getNumericValue(n.charAt(0))); }
        return super_digit(sum_n_big(n).toString());
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);
 
        BigInteger result = sum_n_big(n);
        result = result.multiply(BigInteger.valueOf(k));
        result = super_digit(result.toString());

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
