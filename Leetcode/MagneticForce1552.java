import java.util.*;
public class MagneticForce1552 {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 0;
        int right = position[position.length-1]-position[0];

        while (left < right) {
            int middle = (left+right+1)/2;

            if (distanceMoreThan(position, middle, m)) {
                left = middle;
            } else {
                right = middle-1;
            }
        }

        return left;
    }

    private static boolean distanceMoreThan(int[] position, int dist, int m) {
        int lastIndex = 0;
        int count = 1;

        for (int i = 1; i < position.length; ++i) {
            if (position[i] - position[lastIndex] >= dist) {
                count++;
                lastIndex = i;
            }

            if (count == m) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,7};
        int n = 3;
        maxDistance(nums, n);
    }
}
