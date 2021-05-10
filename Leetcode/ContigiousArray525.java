import java.util.*;
public class ContigiousArray525 {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
                map.put(1,map.getOrDefault(nums[i],0) + 1);
            else
                map.put(0,map.getOrDefault(0,0) +1);
            if(map.get(0) == map.get(1) && (map.get(0) + map.get(1) == i+1))
                res = Math.max(res,2 * map.get(0));

        }
        if(map.get(0) + map.get(1) == nums.length && map.get(0) == map.get(1))
            return nums.length;
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0,1,0};
        System.out.println(findMaxLength(arr));
    }
}
