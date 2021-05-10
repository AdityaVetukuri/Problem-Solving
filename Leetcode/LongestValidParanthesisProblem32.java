import java.util.*;
public class LongestValidParanthesisProblem32 {
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
//            if (s == null || "".equals(s)) return 0;
//    int[] dp = new int[s.length() + 1];
//    int max = 0;
//        for (int i = 1; i < s.length(); i++) {
//        if (s.charAt(i) == ')' && i - dp[i] >= 1 && s.charAt(i - dp[i] - 1) == '(') {
//            dp[i + 1] = dp[i - dp[i] - 1] + dp[i] + 2;
//        }
//    }
//        for (int i = 0; i < dp.length; i++) {
//        if (dp[i] > max) max = dp[i];
//    }
//        return max;


    public static void main(String[] args) {
        String str = "()(())";
        longestValidParentheses(str);
    }
}
