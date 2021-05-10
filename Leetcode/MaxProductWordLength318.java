import java.util.*;
public class MaxProductWordLength318 {
    public static int maxProduct(String[] words) {
        int n=words.length;

        int temp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            String word=words[i];
            int val=1;
            int store=0;
            for(int j=0;j<word.length();j++)
            {
                int shift=(int)(word.charAt(j)-97);
                store=store|(val<<shift);
            }
            temp[i]=store;
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if((temp[i]&temp[j])==0)
                {
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;

    }

    private static String toBits(String word) {
        int[] arr = new int[26];
        for(int i = 0; i < word.length(); i++)
        {
            arr[word.charAt(i) - 'a']++;
        }
        String str = "";
        for(int i =0 ; i < 26; i++)
        {
            str += Integer.toString(arr[i]);
        }
        return str;
    }

    public static void main(String[] args) {
       String[] words = new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
       maxProduct(words);
    }

}
