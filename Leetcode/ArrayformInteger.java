import java.util.*;
class ArrayformInteger {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        addToArrayForm(arr,k);
    }
}