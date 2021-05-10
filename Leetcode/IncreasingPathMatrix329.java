class IncreasingPathMatrix329 {
    public static boolean visited[][];
    public static int longestPath = 0;
    public static int longestIncreasingPath(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                visited = new boolean[matrix.length][matrix[0].length];
                dfs(matrix, i, j, visited, 0, 0);
            }
        }
        return longestPath;
    }
    public static void dfs(int matrix[][], int i, int j, boolean visited[][], int prev, int path)
    {
        if(i < 0 || j  < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] == true)
            return;

        if(matrix[i][j] > prev)
        {
            path++;
            longestPath = Math.max(longestPath, path);
            visited[i][j] = true;
            dfs(matrix, i+1, j, visited, matrix[i][j], path);
            dfs(matrix, i, j+1, visited, matrix[i][j], path);
            dfs(matrix, i-1, j, visited, matrix[i][j], path);
            dfs(matrix, i, j-1, visited, matrix[i][j], path);
        }
        else
            return;

    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        longestIncreasingPath(arr);
    }
}