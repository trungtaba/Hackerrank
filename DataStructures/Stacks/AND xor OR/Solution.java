//https://www.hackerrank.com/challenges/and-xor-or/problem

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int andXorOr(int m1, int m2){
        return ((m1&m2)^(m1|m2))&(m1^m2);
    }
    static int andXorOr(int[] a) {
        Stack<Integer>stack=new Stack<>();
        int maxValue=andXorOr(a[0],a[1]);
        int value;
        for(int i:a){
            while(!stack.empty()){
                int top=stack.peek();
                value=andXorOr(i, top);
                if(maxValue<value){
                    maxValue=value;
                }
                if(i<top){
                    stack.pop();
                }else break;
                
            }
            stack.push(i);
        }
        return maxValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)   {
        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        String[] aItems = scanner.nextLine().split(" ");

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int result = andXorOr(a);
        System.out.println(result);
    }
}
