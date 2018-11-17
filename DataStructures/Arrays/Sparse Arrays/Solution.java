
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashMap<String,Integer> map=new HashMap<>();
        
        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            if(map.containsKey(stringsItem)){
                int value=map.get(stringsItem)+1;
                map.replace(stringsItem, value);
            }else{
                map.put(stringsItem, 1);
            }
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            if(map.containsKey(queriesItem)){
                System.out.print(map.get(queriesItem));
            }else{
                System.out.print("0");
            }
            if(i!=queriesCount){
                System.out.println("");
            }
        }

        scanner.close();
    }
}
