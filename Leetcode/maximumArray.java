class maximumArray {
    public static int findLength(int[] A, int[] B) {
        int m  = A.length;
        int n =  B.length;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(A[i-1] == B[j-1])
                {
                    dp[i][j] = 1 + Math.max(dp[i-1][j], dp[i][j-1]);
                    max = Math.max(max,dp[i][j]);
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = new int[]{1,2,3,2,1};
        int B[] = new int[]{3,2,1,4,7};
        System.out.println(findLength(A,B));
    }
}