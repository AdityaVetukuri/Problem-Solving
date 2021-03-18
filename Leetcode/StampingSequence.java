import java.util.*;
class StampingSequence {
    public static int[] movesToStamp(String stamp, String target) {
        char S[] = stamp.toCharArray();
        char T[] = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean visited[] = new boolean[T.length];
        int stars = 0;
        while(stars < T.length)
        {
            boolean doneReplace = false;
            for(int i =0; i <= T.length - S.length; i++)
            {
                if(!visited[i] && canReplace(T, i, S))
                {
                    visited[i] = true;
                    stars = doReplace(T,i,S.length,stars);
                    doneReplace = true;
                    res.add(i);
                    if(stars == T.length)
                    {
                        break;
                    }
                }
            }
            if(!doneReplace)
            {
                return new int[0];
            }
        }
        int[] resArray = new int[res.size()];
        for(int i =0; i < res.size(); i++)
        {
            resArray[i] = res.get(res.size() - i -1);
        }
        return resArray;
    }

    private static boolean canReplace(char[] T, int p, char[] S) {
        for(int i =0; i < S.length; i++)
        {
            if(T[i+p] != '*' && T[i+p]!=S[i])
                return false;
        }
        return true;
    }

    private static int doReplace(char[] T, int p, int len, int count) {
        for(int i = 0; i < len; i++)
        {
            if(T[i+p] != '*')
            {
                T[i+p] = '*';
                count++;
            }
        }
        return count;
    }

    public static void main(String args[])
    {
        String str1= "abc";
        String str2 = "ababcbc";
        movesToStamp(str1, str2);
    }
}