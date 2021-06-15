public class PalindromicSubstrings {
        public static int countSubstrings(String s) {
            boolean dp[][] = new boolean[s.length()][s.length()];
            int count = 0;
            for(int i = 0; i < s.length(); i++)
            {
                dp[i][i] = true;
                count++;
            }
            for(int i = 1; i < s.length(); i++)
            {
                if(s.charAt(i) == s.charAt(i-1))
                    dp[i-1][i] = true;
                    count++;
            }
            for(int k = 3; k <= s.length(); k++)
            {
                for(int i = 0; i <= s.length() - k; i++)
                {
                    int j = i + k - 1;
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    if(dp[i][j] == true)
                        count++;
                }
            }
            return count;
        }
    public static void main(String[] args) {
        String str = "aaa";
        countSubstrings(str);
    }
}
