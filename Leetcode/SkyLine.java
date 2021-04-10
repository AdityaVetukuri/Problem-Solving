import java.awt.desktop.SystemEventListener;

class SkyLine {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                res += findMax(grid, i,j) - grid[i][j];
            }
        }
        return res;
    }
    public static int findMax(int[][] grid,int i, int j)
    {
        int rowMax = Integer.MIN_VALUE, columnMax = Integer.MIN_VALUE;
        for(int k = 0; k < grid.length; k++)
        {
            rowMax = Math.max(rowMax, grid[i][k]);
        }
        for(int k = 0; k < grid[0].length; k++)
        {
            columnMax = Math.max(columnMax, grid[k][j]);
        }
        return Math.min(rowMax,columnMax);
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(arr));
    }
}