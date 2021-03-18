import java.util.*;
public class longestArithmeticSubsequence {
    public static int longestSubsequence(int[] arr, int difference) {
        if(arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap();
        int maxSequence = 0;
        for (int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(map.containsKey(num-difference)){
                int num1 = map.getOrDefault(num, 0);
                int num2 = 1+ map.get(num-difference);
                map.put(num, Math.max(num1, num2));
            }else{
                map.put(num, 1);
            }
            maxSequence = Math.max(maxSequence, map.get(num));
        }
        return maxSequence;
    }
    public static int longestSubsequenceDP(int[] arr, int difference) {
        if (arr == null || arr.length == 0) return 0;
        int l = arr.length;
        int[] dp = new int[20_000 + 1];

        int result = 1;
        for(int i = 1; i<=l; i++) {
            int temp = arr[i-1];
            if (temp - difference > 10_000 || temp - difference <-10_000) {
                dp[temp+10_000] = 1;}
            else {
                dp[temp + 10_000] = dp[temp - difference + 10_000] + 1;
            }
            result = Math.max(dp[temp + 10_000], result);
        }
        return result;
    }

    public static void main(String args[])
    {
        int arr[] = new int[]{1,5,7,8,5,3,4,2,1};
        int difference = -2;
     //   longestSubsequence(arr, difference);
        longestSubsequenceDP(arr, difference);

    }
}
