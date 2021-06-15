public class MinSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0,ans = nums.length;
        int windowStart = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            while(sum >= target)
            {
                sum -= nums[windowStart++];
                ans = Math.min(ans, i - windowStart + 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,4,4};
        int target = 4;
        minSubArrayLen(target, arr);
    }
}
