class NumArray {
    int sumContinuity[];
    public NumArray(int[] nums) {
        sumContinuity = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sumContinuity[i] = nums[i];
            }
            else {
                sumContinuity[i] = sumContinuity[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sumContinuity.length == 0) {
            return 0;
        }
        else {
            int k = 0;
            if (i > 0) {
                k = sumContinuity[i-1];
            }
            return sumContinuity[j] - k;
        }
    }
}