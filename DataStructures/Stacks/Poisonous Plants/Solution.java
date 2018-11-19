
import java.util.*;

//https://www.hackerrank.com/challenges/poisonous-plants/problem
public class Solution {

    static class data {

        int plant;
        int days;

        public data(int plant, int days) {
            this.plant = plant;
            this.days = days;
        }

    }

    static int poisonousPlants(int[] plantArr) {
        Stack<data> stack = new Stack<>();
        int maxDaysAlive = 0;

        for (int i = 0; i < plantArr.length; i++) {
            int daysAlive = 0;

            while (!stack.empty() && plantArr[i] <= stack.peek().plant) {
                daysAlive = Math.max(daysAlive, stack.pop().days);
            }

            if (stack.empty()) {
                daysAlive = 0;
            } else {
                daysAlive += 1;
            }

            maxDaysAlive = Math.max(maxDaysAlive, daysAlive);
            stack.push(new data(plantArr[i], daysAlive));

        }

        return maxDaysAlive;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        System.out.println(result);

        scanner.close();

    }
}
