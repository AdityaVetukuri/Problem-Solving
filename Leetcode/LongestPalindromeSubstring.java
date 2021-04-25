/*Aditya Varma Vetukuri
...
...
...
*/
class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        String longestSubstring = "";
        int longest = 0;
        int n  = s.length();
        int start = 0;
        int end = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i =0; i < s.length(); i++)
        {
            dp[i][i] = true;
        }
        for(int i = 1; i < s.length(); i++)
        {
            dp[i-1][i] = s.charAt(i) == s.charAt(i-1);
            if(dp[i-1][i] && longest <= 2)
            {
                longest = 2;
                start = i-1;
                end   = i;
            }
        }

        for(int L = 3; L <= s.length(); L++)
        {
            for(int i = 0; i <= s.length() - L; i++)
            {
                int j = i + L - 1;
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));

                if(dp[i][j] && longest <= L)
                {
                    longest = L;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}