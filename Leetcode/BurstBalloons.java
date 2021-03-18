public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int[] array = new int[nums.length + 2];
        int len = array.length;
        array[0] = array[len - 1] = 1;
        for (int i = 1; i < len - 1; i++) {
            array[i] = nums[i-1];
        }

        int[][] memo = new int[len][len];

        for (int dis = 2; dis < len; dis++) {
            for (int i = 0; i < len - dis; i++) {
                int left = i, right = left + dis;
                for (int j = left + 1; j < right; j++) {
                    memo[left][right] = Math.max(memo[left][right],
                            array[left] * array[j] * array[right] + memo[left][j] + memo[j][right]);
                }
            }
        }

        return memo[0][len - 1];
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{3,1,5,8};
        maxCoins(arr);
    }
}
