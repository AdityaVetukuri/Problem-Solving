import java.util.*;
class stringPermutation {
    public static boolean checkInclusion(String s1, String s2) {
        char char_s1[] = new char[26];
        char char_s2[] = new char[26];
        if(s1 == s2)
            return true;
        int count = 0;
        for(int i = 0; i < s1.length(); i++)
        {
            char_s1[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s1.length(); i++)
        {
            char_s2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(char_s1,char_s2))
            return true;
        for(int i = s1.length(); i < s2.length();i++)
        {
            char_s2[s2.charAt(i) - 'a']++;
            char_s2[s2.charAt(i-s1.length()) -'a']--;
            if(Arrays.equals(char_s1,char_s2))
                return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        String s1 = "a";
        String s2 = "ab";
        boolean result = checkInclusion(s1,s2);
        System.out.println(result);
    }
}