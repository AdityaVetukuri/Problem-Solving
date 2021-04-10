import java.util.*;
class maximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i < matrix.length; i++)
        {
            Arrays.fill(dp[i],Character.getNumericValue('0'));
        }
        for(int i = 1; i <=m ; i++)
        {
            for(int j = 1; j <=n ; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    if(dp[i-1][j] != 0 && dp[i-1][j-1] != 0 && dp[i][j-1] != 0)
                    {
                        dp[i][j] = Math.max(dp[i][j], 4 * Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])));
                        max = Math.max(max,dp[i][j]);
                    }
                    else
                    {
                        dp[i][j] = Character.getNumericValue(matrix[i-1][j-1]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char squares[][] = new char[][]{{'0','1'},{'1','0'}};
        System.out.println(maximalSquare(squares));
    }
}