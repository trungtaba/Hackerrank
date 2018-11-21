//https://www.hackerrank.com/challenges/down-to-zero-ii/problem
import java.util.Scanner;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int max = 1000001;
        int[] nums =new int[max];
        
        //Initialize array
        for(int i = 0; i < max; ++i) nums[i] = -1;
        nums[0] = 0; nums[1] = 1; nums[2] = 2; nums[3] = 3;
        
        //Precompute
        for(int i = 1; i < max; ++i){
            if(nums[i] == -1 || nums[i] > (nums[i - 1] + 1))
                nums[i] = nums[i - 1] + 1;
            for(int j = 1; j <= i && j * i < max; ++j)
                if(nums[j * i] == -1 || (nums[i] + 1) < nums[j * i])
                    nums[j * i] = nums[i] + 1;
        }
    
        
        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = nums[n];

            System.out.println(result);
        }

        scanner.close();
    }
}
