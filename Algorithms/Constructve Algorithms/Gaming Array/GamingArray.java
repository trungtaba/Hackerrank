import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Solution {

    // Complete the gamingArray function below.
    static String gamingArray(int[] arr) {
        int n=arr.length;
        int tmp=arr[0];
        int count=0;
        for(int i=1;i<n;i++){
            if(arr[i]>tmp) count++;
        }
        if(count%2==0)return "BOB";
        return "ANDY";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int arrCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[arrCount];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < arrCount; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            String result = gamingArray(arr);
            System.out.println(result);
        }

        scanner.close();
    }
}
