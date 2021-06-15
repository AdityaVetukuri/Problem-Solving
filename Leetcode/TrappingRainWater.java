import java.util.*;
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,0,5,2,5};
        trap(arr);
    }

    private static void trap(int[] arr) {
        int ans = 0, ptr = 0;
        Stack<Integer> st = new Stack<>();
        while(ptr < arr.length)
        {
            while(!st.isEmpty() && arr[ptr] > arr[st.peek()])
            {
                int top = st.pop();
                if(st.isEmpty())
                    break;
                int distance = ptr - st.peek() - 1;
                int boundedHeight = Math.min(arr[ptr], arr[st.peek()]) - arr[top];
                ans += distance * boundedHeight;
            }
            st.push(ptr++);
        }

    }
}
