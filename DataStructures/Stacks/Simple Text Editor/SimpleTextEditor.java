import java.util.Scanner;
import java.util.Stack;
public class SimpleTextEditor {
    private static Stack<String> stack=new Stack<>();
    private static String string="";
    public static void append(String s){
        stack.push(string);
        string+=s;      
    }
    
    //2: delete - Delete the last k characters of S
    public static void delete(int k){
        stack.push(string);
        string=string.substring(0, string.length()-k);
    }
    
    //3: print - Print the kth character of S.
    public static void print(int k){
        System.out.println(string.charAt(k-1));
    }
    
    //4: undo
    public static void undo(){
        string=stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String[] query=sc.nextLine().split(" ");
            int queryType=Integer.parseInt(query[0]);
            switch(queryType){
                case 1:
                    append(query[1]);break;
                case 2:
                    delete(Integer.parseInt(query[1]));break;
                case 3:
                    print(Integer.parseInt(query[1]));break;
                case 4:
                    undo();break;                  
            }
        }
    }
}
