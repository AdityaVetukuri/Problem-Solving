import java.util.*;
public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {

        int maxLength = 1;
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < nums.length; i ++)
        {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < i; j ++)
            {
                if(res.size() == 0)
                    res.add(nums[j]);
                if(nums[j] % nums[i] == 0 || nums[i] % nums[j] ==0)
                {
                    temp.add(nums[j]);
                    if(temp.size() > maxLength)
                    {
                        maxLength = temp.size();
                        res = temp;
                    }
                }
            }
        }
        if(nums.length == 1)
            res.add(nums[0]);
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,17};
        largestDivisibleSubset(arr);
    }
}
