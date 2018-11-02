import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        long r = scanner.nextLong();
        long c = scanner.nextLong();
        long ans = (r % 2 == 1 ? (r - 1) * 5 + (c - 1) * 2 : (r - 2) * 5 + 1 + (c - 1) * 2);
        System.out.print(ans);

        scanner.close();
    }
}
