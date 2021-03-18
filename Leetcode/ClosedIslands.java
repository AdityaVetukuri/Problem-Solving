class ClosedIslands {
    public boolean[][] visited;
    public int closedIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i =0; i< grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 0 && !(visited[i][j]))
                {
                    if(dfs(grid,i,j,visited))
                        count+=1;
                }

            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited)
    {
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length)
            return false;
        if(visited[i][j] == true)
            return true;
        visited[i][j] = true;
        if(grid[i][j] == 1)
            return true;
        boolean top = dfs(grid,i-1,j,visited);
        boolean bottom = dfs(grid,i+1,j,visited);
        boolean left = dfs(grid,i,j-1,visited);
        boolean right = dfs(grid,i,j+1,visited);
        return top && bottom && left && right;
    }
}