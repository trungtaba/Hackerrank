import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the divisors function below.
     */
    static int divisors(int n) {
        int count=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(i%2==0) count++;
                int tmp=n/i;
                if(tmp!=i && tmp%2==0) count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = divisors(n);

            
            System.out.println(result);
        }
    }
}
