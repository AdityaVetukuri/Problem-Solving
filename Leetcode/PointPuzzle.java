import java.util.*;
public class PointPuzzle {
    public static int maxPoints(int[] nums)
        {
            int[] count = new int[100001];
            for (int x: nums) count[x]++;
            int avoid = 0, using = 0, prev = -1;

            for (int k = 0; k <= 100000; ++k) if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
            return Math.max(avoid, using);
        }
    public static void main(String args[])
    {
        int[] arr = new int[]{5,6,6,7,4,11};
        int[] arr1 = new int[]{3,4,2};
        System.out.println(maxPoints(arr));
        System.out.println(maxPoints(arr1));
    }

}
