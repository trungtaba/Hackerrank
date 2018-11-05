import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int sumDigit(int a) {
        int sum = 0;
        while (a >= 10) {
            sum += a % 10;
            a /= 10;
        }
        sum += a;
        return sum;
    }

    static int sumPrimeFactor(int n){
        int sumFactors=0;
        for(int i = 2; i<= n; i++) {
            while(n%i == 0) {
                //System.out.println("sumFactor="+sumFactors);
               sumFactors+=sumDigit(i);
               n = n/i;
            }
        }
        if(n >2) {
            sumFactors+=sumDigit(n);
        }

        return sumFactors;
    }

    static int solve(int n) {
        int sumDigit=sumDigit(n);
        //System.out.println("sumDigit="+sumDigit);
        int sumFactor=sumPrimeFactor(n);
        //System.out.println("sumFactor="+sumFactor);
        return sumDigit==sumFactor?1:0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = solve(n);

        System.out.println(result);

        scanner.close();
    }
}
