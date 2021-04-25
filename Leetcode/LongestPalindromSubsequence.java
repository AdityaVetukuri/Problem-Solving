import java.util.*;
class LongestPalindromSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];


        for(int i =0; i < n; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        for(int i = 0; i < n; i++)
        {
            dp[i][i] = 1;
        }

        for(int L = 2; L <= s.length(); L++)
        {
            for(int i = 0; i <= s.length() - L; i++)
            {
                int j = i + L - 1;

                if(L == 2 && s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = 2;
                }
                else if (s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}