package Searching;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



public class Pairs {
    static int pairs(int k, int[] arr,HashMap<Integer,Boolean> hashMap) {
        int result=0;
        for(int i=0;i<arr.length;i++){
            int tmp=arr[i]+k;
            if(hashMap.containsKey(tmp))
                result ++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
            hashMap.put(arrItem, Boolean.TRUE);
        }

        int result = pairs(k, arr,hashMap);

        System.out.println(result);
        scanner.close();
    }
}
