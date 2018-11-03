import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> divisorArray = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisorArray.add(i);
                int tmp = n / i;
                if (tmp != i)
                    divisorArray.add(tmp);
            }
        }
        return divisorArray;
    }

    static boolean isValid(int[] a, int size) {
        int remain = size;
        for (int oneA : a) {
            if (remain == oneA) {
                remain = size;
            } else if (remain < oneA) {
                return false;
            } else {
                remain -= oneA;
            }
        }
        return remain == size;
    }

    static List<Integer> solve(int[] a) {
        int sum = Arrays.stream(a).sum();
        
        List<Integer> sizes = new ArrayList<Integer>();
        ArrayList<Integer> divisors=divisors(sum);
        for(int divisor: divisors ){
            if( isValid(a, divisor) ){
                sizes.add(divisor);
            }
        }
        
        Collections.sort(sizes);
        return sizes;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(String.join(" ", solve(a).stream().map(Object::toString).collect(Collectors.toList())));

        sc.close();
    }
}