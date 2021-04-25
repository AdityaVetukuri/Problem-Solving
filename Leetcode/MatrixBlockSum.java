class MatrixBlockSum {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[][] {};
        int m = mat.length;
        int n = mat[0].length;

        int prefixSum[][] = new int[m+1][n+1];

        for(int i = 1; i <= m; ++i)
        {
            for(int j = 1; j <= m; ++j)
            {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int ans[][] = new int[m][n];

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <=m ; j++)
            {
                int forwardX = Math.min(m,i+k);
                int forwardY = Math.min(n,j+k);

                int backwardX = Math.max(1, i - k);
                int backwardY = Math.max(1, j - k);

                ans[i-1][j-1] = prefixSum[forwardX][forwardY] - prefixSum[backwardX-1][forwardY] - prefixSum[forwardX][backwardY-1] + prefixSum[backwardX-1][backwardY-1];
            }
        }
        return ans;

    }



    public static void main(String[] args) {
        int arr[][] = new int[][]{{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int res[][] = matrixBlockSum(arr, 3);
    }
}
