import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SherlockandArray {

       static String balancedSums(List<Integer> arr) {
        //String correct="NO";
        int size=arr.size();
        int index=0;
        int left=0;
        int right=0;
        for(int i=1;i<size;i++){
            right+=arr.get(i);
        }
        if(right==left){
            return "YES";
        }
       
        for(int i=1;i<=size-1;i++){
            //System.out.println("index="+index+"\tleft="+left+"\tright="+right);
            if(right==left){
                return "YES";
            }else{
                left+=arr.get(index);
                
                right-=arr.get(index+1);
                index++;
            }
        }
        if(right-arr.get(size-1)==0){
            return "YES";
        }
        return "NO";

    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
