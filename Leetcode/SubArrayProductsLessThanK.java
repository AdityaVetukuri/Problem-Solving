import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int product) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here
        //2  5  3 10
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        if(arr[0]  < product) {
            list.add(arr[0]);
        }
        subarrays.add(list);
        int windowStart = 0;
        for(int i = 1; i < arr.length; i++)
        {
            sum *= arr[i];
            if(sum < product)
            {
                list.add(arr[i]);
                subarrays.add(list);
            }
            else
            {
                while(sum >= product)
                {
                    sum /= arr[windowStart];
                    list.remove(0);
                    windowStart++;
                }
                if(sum < product)
                {
                    subarrays.add(list);
                }
            }
            if(arr[i] < product)
            {
                subarrays.add(Arrays.asList(arr[i]));
            }
        }
        return subarrays;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 10};
        int target = 30;
        findSubarrays(arr ,target);
    }
}