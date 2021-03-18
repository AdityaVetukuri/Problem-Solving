import java.util.*;
public class OutOfBoundaryPaths {
    public static void main(String args[])
    {
        int m  = 1, n = 3, N = 3, i = 0, j =1;
        int result = findPaths(m,n,N,i,j);
    }

    private static int findPaths(int m, int n, int N, int i, int j) {
        int memo[][][] = new int[m][n][N+1];
        for(int[][] mem : memo)
        {
            for(int[] me : mem)
            {
                Arrays.fill(me,-1);
            }
        }
        return findPathsDfs(m,n,N,i,j,0,memo);
    }

    private static int findPathsDfs(int m, int n, int moves, int row_pos, int column_pos, int count, int[][][] memo) {
        if(row_pos == -1 || column_pos == -1 || row_pos ==m || column_pos ==n)
        return 1;

        if(memo[row_pos][column_pos][count] != -1)
            return memo[row_pos][column_pos][count];

        if(count < moves)
        {
            int mod = 1_0000_0000_7;
            int up  = findPathsDfs(m, n, moves,row_pos-1,column_pos,count+1,memo) % mod;
            int down = findPathsDfs(m, n, moves,row_pos+1,column_pos,count+1,memo) % mod;
            int left = findPathsDfs(m, n, moves, row_pos, column_pos-1,count+1,memo) % mod;
            int right = findPathsDfs(m,n,moves,row_pos,column_pos+1,count+1,memo) % mod;
            memo[row_pos][column_pos][count] = ((up+down) % mod + (left + right) % mod) % mod;
            return memo[row_pos][column_pos][count];
        }
        return 0;
    }
}
