
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] nq = sc.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);
        List<Integer> seq;
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAns = 0;
        for (int i = 0; i < q; i++) {
            String[] userInputSplits = sc.nextLine().split(" ");
            int queryType = Integer.parseInt(userInputSplits[0]);
            int x = Integer.parseInt(userInputSplits[1]);
            int y = Integer.parseInt(userInputSplits[2]);

            int seqIndex = (x ^ lastAns) % n;
            switch (queryType) {
            case 1:
                if (seqList.size()-1>=seqIndex )
                    seqList.get(seqIndex).add(y);
                else {
                    seq = new ArrayList<Integer>();
                    seq.add(y);
                    seqList.add(seqIndex, seq);
                }
                break;
            case 2:
                seq = seqList.get(seqIndex);
                lastAns = seq.get(y % seq.size());
                System.out.println(lastAns);
                break;
            }

        }

        sc.close();
    }
}

