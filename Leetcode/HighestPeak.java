import java.util.*;
class HighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int matrix[][] = new int[m][n];
        int dirs[][] = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++)
        {
            Arrays.fill(matrix[i],-1);
            for(int j = 0;j < n; j++)
            {
                if(isWater[i][j] == 1)
                {
                    matrix[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty())
        {
            int curr[] = queue.poll();
            for(int[] dir: dirs)
            {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];


                if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y]!=-1) continue;

                matrix[x][y] = matrix[curr[0]][curr[1]] + 1;

                queue.add(new int[]{x,y});
            }
        }
        return matrix;
    }
}

