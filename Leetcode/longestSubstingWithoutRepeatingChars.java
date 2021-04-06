import java.util.*;
class longestSubstringWithoutReaptingChars {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            if(!set.add(c)) {
                while(s.charAt(left) != c) {
                    set.remove(s.charAt(left++));
                }
                left++;
            }
            res = Math.max(res, set.size());
            right++;
        }
        return res;
    }
    public static void main(String args[])
    {
        String str = "abcabcbb";
        lengthOfLongestSubstring(str);
    }

}