class minimumSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        boolean flag = false;
        int sum = 0;
        int j=0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];

            while(sum >= target)
            {
                flag = true;
                sum = sum-  nums[j];
                ans = Math.min(ans,i-j+1);
                j++;

            }
        }
        if(flag)
            return ans;
        else
            return 0;


    }
}