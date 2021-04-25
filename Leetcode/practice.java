class practice {
    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length + 1];
        if(nums.length == 0)
            return 0;
        dp[0] = 1;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                else
                {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }

        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        int arr[] = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));

    }
}