import java.util.*;
class minimumIncrement {
    public static int minIncrementForUnique(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        int moves = 0;
        System.out.println(map);

        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {

            {

                Map.Entry<Integer, Integer> entry = itr.next();
                int val = entry.getValue();
                if (val > 1) {
                    map.put(entry.getKey(), 1);
                }
                int incrementValue = entry.getKey() + 1;
                if (map.get(incrementValue) != null) {
                    int getIncrementValue = map.get(incrementValue);
                    map.put(incrementValue, getIncrementValue + (val - 1));
                } else {
                    map.put(incrementValue, val - 1);
                }
                moves = moves + (val - 1);
            }
        }
        return moves;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{3,2,1,2,1,7};
        minIncrementForUnique(arr);
    }
}