import java.util.*;

public class LargestSubMatrix {
    static int reArrange(int[][] matrix)
        {
            int m = matrix.length;
            int n = matrix[0].length;
            int largestArea = 0;
            int l = 1;

            for(int i =1; i < m; i++)
            {
                for(int j =0; j < n; j++)
                {
                    if(matrix[i][j]==1)
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                }
            }
            for(int[] row : matrix)
            {
                Arrays.sort(row);
                for(int i = 0; i < n; i++)
                {
                    largestArea = Math.max(largestArea, row[i]*(n-i));
                }

            }

            return largestArea;
        }

        static int[] reverse(int[] arr)
        {
            int ptr1 = 0;
            int ptr2 = arr.length-1;

            while(ptr1 < ptr2)
            {
                int temp = arr[ptr1];
                arr[ptr1] = arr[ptr2];
                arr[ptr2] = temp;
                ptr1++;
                ptr2--;
            }
            return arr;
        }

    public static void main(String[] args) {
        int arr[][]  = new int[][]{{0,0,1},{1,1,1},{1,0,1}};
        System.out.println(reArrange(arr));
    }
}
