import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[]array=new long[n+1];
        long maxValue=Long.MIN_VALUE;
        long x=0;
        
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int left=Integer.parseInt(queriesRowItems[0]);
            int right=Integer.parseInt(queriesRowItems[1]);
            int value=Integer.parseInt(queriesRowItems[2]);
            
            array[left]+=value;
            if((right+1)<=n)
                array[right+1]-=value;
        }
        
        for(int i=1;i<=n;i++){
            x+=array[i];
            if(maxValue<x){
                maxValue=x;
            }
        }


        System.out.println(maxValue);

        scanner.close();
    }
}
