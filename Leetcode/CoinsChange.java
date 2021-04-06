import java.util.*;
class CoinsChange {
    public static int coinChange(int[] coins, int amount) {
        // mininum number of coins that can get to amount   
        // dp[amount] is the number of each time add one on top of current min number of coins 
        // used to construct a certain amount
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,5,7,3,12};
        System.out.println(coinChange(arr,36));
    }
}