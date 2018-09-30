
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Scanner;



public class TaraBeautifulPermutations {

    /*
     * Complete the beautifulPermutations function below.
     */
    static int beautifulPermutations(int[] arr) {
        Hashtable<Integer,Boolean> duplicateInt=new Hashtable<>();
        int n=arr.length;
        int duplicateCount=0;
        for(int a:arr){
            if(!duplicateInt.containsKey(a)){
                duplicateInt.put(a, Boolean.TRUE);
            }else{
                duplicateCount++;
            }
        }
        int singleCount=n-2*duplicateCount;
        
        int count=0;
        
        return count;
    }
    static BigInteger factorial(int n){
        BigInteger value=new BigInteger("1");
        for(int i=0;i<=n;i++){
            value=value.multiply(new BigInteger(i+""));
        }
        
        return value;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int t = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("value="+factorial(3));
        for (int tItr = 0; tItr < t; tItr++) {
            int arrCount = Integer.parseInt(scanner.nextLine().trim());

            int[] arr = new int[arrCount];

            String[] arrItems = scanner.nextLine().split(" ");

            for (int arrItr = 0; arrItr < arrCount; arrItr++) {
                int arrItem = Integer.parseInt(arrItems[arrItr].trim());
                arr[arrItr] = arrItem;
            }

            int result = beautifulPermutations(arr);
            System.out.println(result);
        }
        scanner.close();
    }
}
