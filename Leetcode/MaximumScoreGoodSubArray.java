public class MaximumScoreGoodSubArray {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k, res = nums[k], min = Integer.MAX_VALUE;

        while(i > 0 || j < nums.length-1)
        {
            if(i == 0)
                ++j;
            else if(j == nums.length-1)
                --i;
            else if(nums[i-1] < nums[j+1])
                ++j;
            else
                --i;
            min = Math.min(Math.min(nums[i],nums[j]),min);
            res = Math.max(res,min * (j-i+1));
        }
        return res;
    }
}
