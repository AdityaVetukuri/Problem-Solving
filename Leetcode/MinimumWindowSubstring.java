import java.util.*;
class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";
        int windowStart = 0, smallestLength = Integer.MAX_VALUE, matches = 0;
        for( char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c,0) + 1);
        StringBuilder sb = new StringBuilder(pattern.length());
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    matches++;
            }

            sb.append(c);
            if(matches == pattern.length())
            {
                while(matches == pattern.length())
                {
                    if(i - windowStart + 1 < smallestLength) {

                        res = sb.toString();
                        char prev = str.charAt(windowStart);
                        if (map.containsKey(prev)) {
                            if (map.get(prev) == 0)
                                matches--;
                            map.put(prev, map.get(prev) + 1);
                            sb.deleteCharAt(0);
                        }
                        else
                        {
                            sb.deleteCharAt(0);
                        }
                        windowStart++;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abdbca";
        String pattern = "abc";
        findSubstring(str, pattern);
    }
}