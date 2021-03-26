import java.util.*;
public class MaxSumPermutationRange {
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int len = nums.length;
        int cnt[] = new int[len];
        for(int[] r:requests){
            cnt[r[0]]++;
            if(r[1]+1<len)cnt[r[1]+1]--;
        }
        for(int i=1; i<len; i++)cnt[i]+=cnt[i-1];
        Arrays.sort(cnt);
        Arrays.sort(nums);
        long ans = 0;
        for(int i=len-1; i>=0 && cnt[i]>0; i--){
            ans += (long)cnt[i]*nums[i];
        }
        return (int)(ans%1000000007);
    }
    public static void main(String args[])
    {
        int nums[] = new int[]{1,2,3,4,5,10};
        int requests[][] = new int[][]{{0,2},{1,3},{1,1}};
        maxSumRangeQuery(nums,requests);
    }
}
