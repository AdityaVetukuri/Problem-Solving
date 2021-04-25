
import java.util.*;

class getKthSmallestSum {
    public static int kthSmallest(int[][] mat, int k) {
        List<Integer> li = new ArrayList();
        for(int i=0;i<mat[0].length;i++)
            li.add(mat[0][i]);
        for(int i=1;i<mat.length;i++){
            li = getKthSmallest(mat[i],li,k);
        }
        return li.get(k-1);
    }

   static List<Integer> getKthSmallest(int[] arr,List<Integer> li,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<li.size();j++){
                pq.offer(arr[i]+li.get(j));
            }
        }
        List<Integer> res = new ArrayList();
        for(int i=1;i<=k && !pq.isEmpty();i++){
            int sum = pq.poll();
            res.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,10,10},{1,4,5},{2,3,6}};
        System.out.println(kthSmallest(arr,5));
    }
}