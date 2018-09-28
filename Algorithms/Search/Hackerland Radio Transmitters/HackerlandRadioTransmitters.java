package Searching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class HackerlandRadioTransmitters {
    
    static int hackerlandRadioTransmitters(ArrayList<Integer> x,int n, int k) {   
        int transmitterCount=0;
        Collections.sort(x);
        int i=0;
        while (i<n)
        {
            int counter = 1;
            while (i + counter < n && x.get(i + counter) - x.get(i) <= k)
                counter++;

            transmitterCount++;//install a transmitter
            i = i + counter - 1; //array index of the house where we just installed a transmitter
            //System.out.println("i="+i);
            //now find the index of next house which is out of range from the transmitter we've just installed above.
            counter = 1;
            while (i + counter < n && x.get(i + counter) - x.get(i) <= k)
                counter++;

            i += counter;

        }
        return transmitterCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        ArrayList<Integer>x=new ArrayList<>(n);

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x.add(i, xItem);
        }

        int result = hackerlandRadioTransmitters(x,n,k);
        System.out.println(result);

        scanner.close();
    }
}
