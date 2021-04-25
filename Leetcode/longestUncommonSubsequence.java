class longestUncommonSubsequence {
    public static int findLUSlength(String[] strs) {
        int max = 0;

        for(int i = 0; i < strs.length; i++)
        {
            for(int j = i+1; j < strs.length; j++)
                max = Math.max(max, longestUncommonSubSequence(strs[i],strs[j]));
        }
        return max;
    }
    public static int longestUncommonSubSequence(String a, String b)
    {
        int m = a.length();
        int n = b.length();

        int dp[][] = new int[m+1][n+1];

        for(int i = 1; i <= m ; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(a.charAt(i-1)!=b.charAt(i-1))
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
                else
                {
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc","cdc","eae"};

        System.out.println(findLUSlength(strs));

    }
}