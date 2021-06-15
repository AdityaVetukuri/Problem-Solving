class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1' && visited[i][j]!= true)
                {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int i , int j , boolean[][] visited)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0')
        {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1,j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};
        numIslands(grid);
    }
}