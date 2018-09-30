import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the chiefHopper function below.
    static int chiefHopper(int[] arr){
        int n = arr.length;
        int minEnergy=0;
        for (int i = n - 1; i >= 0; i--) {
            int buildingHeigh=arr[i];
            if(buildingHeigh>minEnergy){
                minEnergy+=(int)Math.ceil((buildingHeigh-minEnergy)/2.0);
            }else{
                minEnergy=(int)Math.ceil((minEnergy+buildingHeigh)/2.0);
            }
        }
        return minEnergy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = chiefHopper(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
