import java.util.*;
class MaxOverlapSum {
    public static int maxNonOverlapping(int[] nums, int target) {
        int[] ends = new int[nums.length + 1];
        Map<Integer, Integer> indexs = new HashMap<>();
        indexs.put(0,0);
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            ends[i + 1] = ends[i];
            if (indexs.containsKey(sum - target)) {
                ends[i + 1] = Math.max(ends[i + 1], ends[indexs.get(sum - target)] + 1);
            }
            indexs.put(sum, i + 1);
        }
        return ends[nums.length];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-2,6,6,3,5,4,1,2,8};
        int target = 10;
        maxNonOverlapping(arr, target);
    }
}