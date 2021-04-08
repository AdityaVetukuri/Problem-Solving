import java.util.*;
class patternMatching {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap<>();
        String[] strings = s.split(" ");
        for(int i = 0; i < pattern.length(); i++)
        {
            if(map.get(strings[i]) == null)
            {
                map.put(strings[i],pattern.charAt(i));
            }
            else
            {
                if(!map.get(strings[i]).equals(pattern.charAt(i)))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern,s));
    }
}