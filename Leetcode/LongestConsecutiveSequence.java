import java.util.*;
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        int count = 1;
        for(int i :nums)
        {
            set.add(i);
        }
        Integer res[] = set.toArray(new Integer[set.size()]);
        Arrays.sort(res);
        for(int i =1 ; i < res.length;i++)
        {
            if(res[i] == res[i-1] +1)
            {
                count++;
                if(count > max)
                    max = count;
            }
            else
                count = 1;
        }
        for(int i =1 ; i < res.length;i++)
            System.out.print(res[i] + " ");
        return max;
    }
}