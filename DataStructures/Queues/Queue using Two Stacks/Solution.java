
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int count = Integer.parseInt(scanner.nextLine().trim());
        ArrayList<Integer>array=new ArrayList<>();
        for(int i=0;i<count;i++){
            String[]query=scanner.nextLine().split(" ");
            switch(query[0]){
                case "1":
                    array.add(Integer.parseInt(query[1])); break;
                case "2":
                    array.remove(0);break;         
                case "3":
                    System.out.println(array.get(0));
            }
        }
        scanner.close();
    }
}
