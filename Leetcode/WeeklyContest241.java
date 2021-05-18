import java.util.*;
public class WeeklyContest241 {
    public static int subsetXORSum(int[] nums) {
        int ans = 0;
        List<List<Integer>> subSets = subsets(nums);

        for(List<Integer> subList : subSets)
        {
            if(subList.size() != 0) {
                int value = subList.get(0);
                for (int i = 1; i < subList.size(); i++) {
                    value = value ^ subList.get(i);
                }
                ans += value;
            }
        }
        return ans;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsHelper(List<List<Integer>> list, ArrayList<Integer> resultList, int[] nums, int start) {
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length; i++){
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }
    public static int minSwaps(String s) {
        int ones = 0, zeros = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
                ones++;
            else
                zeros++;
        }
        if(Math.abs(ones - zeros) >  1)
            return -1;


        if(ones > zeros)
            return helper(s, '1');
        else if(zeros > ones)
            return helper(s, '0');

        return Math.min(helper(s, '1'), helper(s, '0'));
    }

    private static int helper(String s, char c) {
        int swaps = 0;
        for(char ch : s.toCharArray())
        {
            if(ch!= c) {
                swaps++;
            }
            ch ^= 1;
        }
        return swaps / 2;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5,1,6};
        //subsetXORSum(arr);
        String str = "111000";
        minSwaps(str);
    }
}
