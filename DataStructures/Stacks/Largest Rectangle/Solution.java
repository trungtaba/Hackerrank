
//https://www.hackerrank.com/challenges/largest-rectangle/problem

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static long largestRectangle(int[] input) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length;) {
            if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                // if stack is empty means everything till i has to be
                // greater or equal to input[top] so get area by
                // input[top] * i;
                if (stack.isEmpty()) {
                    area = input[top] * i;
                } // if stack is not empty then everythin from i-1 to input.peek() + 1
                  // has to be greater or equal to input[top]
                  // so area = input[top]*(i - stack.peek() - 1);
                else {
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pollFirst();
            // if stack is empty means everything till i has to be
            // greater or equal to input[top] so get area by
            // input[top] * i;
            if (stack.isEmpty()) {
                area = input[top] * i;
            } // if stack is not empty then everything from i-1 to input.peek() + 1
              // has to be greater or equal to input[top]
              // so area = input[top]*(i - stack.peek() - 1);
            else {
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<Integer>();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);

        scanner.close();
    }
}
