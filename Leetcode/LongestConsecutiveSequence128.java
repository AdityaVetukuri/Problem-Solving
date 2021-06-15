import java.util.*;
public class LongestConsecutiveSequence128 {
    public HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> setRep;
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        setRep = new HashMap<>();
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {

                map.put(nums[i], 1);
                setRep.put(nums[i], nums[i]);

        }

        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i] - 1))
            {

                int xRep = find(nums[i]);
                int yRep = find(nums[i] -1);

                union(xRep, yRep);
            }
        }
        for(int i = 0; i < nums.length; i++)
        {
            maxLength = Math.max(maxLength, map.get(nums[i]));
        }
        return maxLength;
    }
    public int find(int key)
    {
        while(setRep.get(key) != key)
        {
            key = setRep.get(key);
        }
        return key;
    }

    public void union(int xRep,int yRep)
    {
        if(xRep == yRep)
            return;
        int a = map.get(xRep);
        int b = map.get(yRep);

        if(a >= b)
        {
            int val = map.get(xRep) + map.get(yRep);
            map.put(xRep,val);
            setRep.put(yRep, xRep);
        }
        else
        {
            int val = map.get(xRep) + map.get(yRep);
            map.put(yRep, val);
            setRep.put(xRep, yRep);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        LongestConsecutiveSequence128 obj = new LongestConsecutiveSequence128();
        obj.longestConsecutive(nums);
    }
}