
//https://www.hackerrank.com/challenges/largest-rectangle/problem
import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static long largestRectangle(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        int area_with_top; // To store area with top bar as the smallest bar 

        int i = 0;
        while (i < input.length) {
            if (stack.empty() || input[stack.peek()] <= input[i]) {
                stack.push(i++);
            } else {
                tp = stack.peek();
                stack.pop();
                area_with_top = input[tp] * (stack.empty() ? i : (i - stack.peek() - 1));
                if (max_area < area_with_top) {
                    max_area = area_with_top;
                }
            }
        }
        while (!stack.empty()) {
            tp = stack.peek();
            stack.pop();
            area_with_top = input[tp] * (stack.empty() ? i : (i - stack.peek() - 1));
            if (max_area < area_with_top) {
                max_area = area_with_top;
            }

        }
        return max_area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
