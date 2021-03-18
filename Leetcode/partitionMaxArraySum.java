class partitionMaxArraySum {
    static int getMax(int[] arr, int i, int j) {
        int r = 0;
        for (int k = i; k <= j; k++) {
            r = Math.max(r, arr[k]);
        }
        return r;
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = Math.max(i - k + 1, 0); j <= i; j++) {
                dp[i] = Math.max(dp[i], (j - 1 < 0 ? 0 : dp[j - 1]) + getMax(arr, j, i) * (i - j + 1));
            }
        }
        return dp[arr.length - 1];
    }
    public static void main(String args[])
    {
            int arr[] = new int[]{1,15,7,9,2,5,10};
            int k = 3;
            int result = maxSumAfterPartitioning(arr,k);
            System.out.println(result);
    }
}