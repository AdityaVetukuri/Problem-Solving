class NondecreasingArray {
    public static boolean checkPossibility(int[] nums) {
        int numViolations = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {

                if (numViolations == 1) {
                    return false;
                }

                numViolations++;

                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,8,8,6,7};
        checkPossibility(arr);
    }
}