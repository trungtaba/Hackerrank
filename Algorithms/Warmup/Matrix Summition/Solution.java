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


class Result {

    /*
     * Complete the 'findMatrix' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY after as parameter.
     */

//    public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
//        
//        List<List<Integer>> before=new ArrayList<>();
//        int n=after.size();
//        int m=after.get(1).size();
//        for(int i=0;i<n;i++){
//            ArrayList<Integer> list=new ArrayList<>();
//            for(int j=0;j<m;j++){
//                int afterij1=0;
//                int beforei1j=0;
//                if(j>0){
//                    afterij1=after.get(i).get(j-1);
//                }
//                if(i>0){
//                    for(int k=0;k<i;k++){
//                        beforei1j+=before.get(k).get(j);
//                    }
//                }
//                int beforeij=after.get(i).get(j)-afterij1-beforei1j;
//                list.add(beforeij);
//            }
//            
//            before.add(list);
//        }
//        return before;
//
//    }
    public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
        List<List<Integer>> before=new ArrayList<>();
        List<List<Integer>> tmp=new ArrayList<>();
        int n=after.size();
        int m=after.get(1).size();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            ArrayList<Integer> tmplist=new ArrayList<>();
            for(int j=0;j<m;j++){
                int afterij1=0;
                int beforei1j=0;
                if(j>=0){
                    afterij1=after.get(i).get(j-1);
                }
                if(i>0){
//                    for(int k=0;k<i;k++){
//                        beforei1j+=before.get(k).get(j);
//                    }
                    beforei1j=tmp.get(i-1).get(j);
                }
                int beforeij=after.get(i).get(j)-afterij1-beforei1j;
                list.add(beforeij);
                if(i==0){
                    tmplist.add(beforeij);
                }else{
                    tmplist.add(beforeij+tmp.get(i-1).get(j));
                }
            }
            tmp.add(tmplist);
            before.add(list);
        }
        return before;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int afterRows = Integer.parseInt(bufferedReader.readLine().trim());
        int afterColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> after = new ArrayList<>();

        IntStream.range(0, afterRows).forEach(i -> {
            try {
                after.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.findMatrix(after);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

