
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    int power(int x, int y, int p) {
        int result = 1;

        x = x % p; 
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return result;
    }
    
    static List<Integer> factors(int n){
        List<Integer> factors=new ArrayList<>();
        while(n%2==0){
            
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // Write Your Code Here
        scanner.close();
    }
}
