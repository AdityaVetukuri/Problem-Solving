import java.util.*;
public class findPivot {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        int leftSum = 0, rightSum = sum;
        for(int i = 0; i < nums.length; i++)
        {
            leftSum += nums[i];
            if(leftSum == rightSum)
                return i;
            rightSum -= nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-1,0,-1,-1,0};
        pivotIndex(arr);
    }
}
