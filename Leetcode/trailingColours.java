class trailingColours {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            // for 2
            while (nums[i] == 2 && i <= p2) {
                swap(nums, i, p2);
                p2--;
            }

            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}