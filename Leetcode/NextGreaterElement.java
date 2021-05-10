import java.util.*;
public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
         Stack<Integer> st = new Stack<>();


       for(int i = 0; i <= 2 * n -1; i++)
       {
           while(!st.isEmpty() && nums[st.peek()] < nums[i % n])
           {
               res[st.pop()] = nums[i%n];
           }
           if(i < n)
           {
               st.push(i);
           }

       }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,2,3,4,3,1,2};
        System.out.println(nextGreaterElements(arr));
    }
}
