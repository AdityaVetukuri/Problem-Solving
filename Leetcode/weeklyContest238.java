import java.util.*;
public class weeklyContest238 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j, res = 1;
        long sum = 0;
        for(j = 0; j < nums.length; j++)
        {
            sum += nums[j];
            while(sum + k < (long)nums[j] * (j- i +1))
            {
                sum -= nums[i];
                i++;
            }
            Math.max(res, j - i + 1);
        }
        return res;
    }
    public static int longestBeautifulSubstring(String word)
    {
        HashSet<Character> set = new HashSet<>();
        int ptr1 = 0;
        int ptr2 = 0;
        int res = 0;
        int ans = 0;
        int maxSoFar = 97;
        int flag = 1;
        while(ptr1 < word.length() && ptr2 < word.length())
        {
                if(flag == 1)
                {
                    if(word.charAt(ptr2) == 'a') {
                        set.add(word.charAt(ptr2));
                        ptr2++;
                        res++;
                        flag = 0;
                    }
                    else
                    ptr2++;
                }
                else {
                    if (word.charAt(ptr2) >= maxSoFar) {
                        set.add(word.charAt(ptr2));
                        res++;
                        maxSoFar = (int) word.charAt(ptr2);
                        ptr2++;
                    } else {
                        while (ptr1 != ptr2) {
                            set.remove(word.charAt(ptr1));
                            ptr1++;
                        }
                        maxSoFar = 97;
                        flag = 1;
                        res= 0;
                    }


                    if (set.size() == 5)
                        ans = Math.max(ans, res);
                }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,4};
        String str = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
  //      System.out.println(longestBeautifulSubstring(str));
        int k = 5;
        System.out.println(maxFrequency(arr, k));
    }
}
