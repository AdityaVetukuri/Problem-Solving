class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int  j = 0;
        for(int i =1; i <nums.length; i++)
        {
            if(nums[i] == nums[j] && cnt < 2)
            {
                j++;
                cnt++;
                nums[j] = nums[i];
            }
            else if(nums[i]!=nums[j])
            {
                cnt = 1;
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}