//https://www.hackerrank.com/challenges/equal-stacks/problem

import java.util.HashMap;
import java.util.Scanner;


public class Solution {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        HashMap<Integer,Boolean> map1=new HashMap<>();
        HashMap<Integer,Boolean> map2=new HashMap<>();
        HashMap<Integer,Boolean> map3=new HashMap<>();
        int length1=h1.length;
        int length2=h2.length;
        int length3=h3.length;
        int sum=0;
        for(int i=length1-1;i>=0;i--){
            sum+=h1[i];
            map1.put(sum, Boolean.TRUE);
        }
        sum=0;
        for(int i=length2-1;i>=0;i--){
            sum+=h2[i];
            map2.put(sum, Boolean.TRUE);
        }
        sum=0;
        for(int i=length3-1;i>=0;i--){
            sum+=h3[i];
            map3.put(sum, Boolean.TRUE);
        }
        int max=0;
        for(int value:map1.keySet()){
            if(map2.containsKey(value)&&map3.containsKey(value)){
                if(value>max)
                    max=value;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
        scanner.close();
    }
}
