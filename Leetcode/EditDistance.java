public class EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int dp[][] = new int[m + 1][n + 1];
            //Two empty strings always need insert operations so fill them with             their cell values
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }

            //bottom-up

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else {
                        //find minimum from insertion deletion and replacement
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
            return dp[m][n];
        }
    }
}
