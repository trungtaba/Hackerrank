/*
TrungTaBa: 30/9/2018
hackerrank: https://www.hackerrank.com/challenges/longest-increasing-subsequent/problem
*/
import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    //take O(N^2)
//    static int longestIncreasingSubsequence(int[] arr) {
//        if(arr==null ||arr.length==0)return 0;
//        int n=arr.length;
//        int[] lis=new int[n];
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<i;j++)
//            {
//                if(arr[i]>arr[j]){
//                    lis[i]=Math.max(lis[j]+1, 1);
//                    max=Math.max(max, lis[i]);
//                }
//            }
//        }
//        return max;
//    }
    //take O(N*logN)
        static int longestIncreasingSubsequence(int[] arr) {
        if(arr==null ||arr.length==0)return 0;
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int lastElement;
            if(list.isEmpty()) lastElement=Integer.MIN_VALUE;
            else lastElement=list.get(list.size()-1);
            if(lastElement<arr[i]){
                list.add(arr[i]);
            }else{
                int remove=binarySearch(arr[i], 0, list.size()-1, list);
                list.remove(remove);
                list.add(remove, arr[i]);
            }
        }
        return list.size();
    }
    
    static int binarySearch(int value,int l,int r,ArrayList<Integer> list){
        if(r>l){
            int mid=(l+r)/2;
            if(list.get(mid)==value) return mid;
            if(list.get(mid)<value){
                return binarySearch(value, mid+1, r, list);
            }
            if(list.get(mid)>value){
                return binarySearch(value, l, mid, list);
            }
        }else{
            if(list.get(r)>=value)return r;
        }
        return -1;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {     
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = longestIncreasingSubsequence(arr);
        System.out.println(result);
        scanner.close();
    }
}
