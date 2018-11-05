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

    static String solve(int[] a) {
        if(a.length==1) return (a[0]>1)? "NO": "YES";
        if(a.length==2){
            return (gcd(a[0],a[1])>1)? "NO":"YES";
        }
        int gcdValue=gcd(a[0],a[1]);
        for(int i=2;i<a.length;i++){
            gcdValue=gcd(gcdValue,a[i]);
            if(gcdValue==1) return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
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

            String result = solve(a);

            System.out.println(result);
        }

        scanner.close();
    }
}
