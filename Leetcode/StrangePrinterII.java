import java.util.*;
public class StrangePrinterII {
    public static boolean isPrintable(int[][] targetGrid)
    {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> colors = new HashSet<Integer>();
        int row = targetGrid.length, column = targetGrid[0].length;
        for(int i=0; i < row; i++)
        {
            for(int j =0; j < column; j++)
            {
                colors.add(targetGrid[i][j]);
            }
        }
        for(var c : colors)
        {
            int fr = -1, fc = Integer.MAX_VALUE, lr = -1, lc = -1;
            for(int i=0; i < row; i++)
            {
                for(int j = 0; j < column; j++) {
                    if (targetGrid[i][j] == c) {
                        if (fr == -1)
                            fr = i;
                        fc = Math.min(fc, j);
                        lr = i;
                        lc = Math.max(lc, j);

                    }
                }
            }
            for(int i = fr; i <= lr; i++)
            {
                for(int j = fc; j <= lc; j++)
                {
                    if(targetGrid[i][j]!=c)
                    {
                        graph.computeIfAbsent(c, z->new HashSet<>()).add(targetGrid[i][j]);
                    }
                }
            }

        }
        var visited = new HashSet<Integer>();
        var visiting = new HashSet<Integer>();
        for(var c : colors)
        {
            if(!topSort(visited,visiting, c,graph)) return false;
        }
        return true;
    }

    private static boolean topSort(HashSet<Integer> visited, HashSet<Integer> visiting, Integer c, Map<Integer, Set<Integer>> graph) {
        if(visited.contains(c))
        return true;
        if(visiting.contains(c))
            return false;
        visiting.add(c);
        for(var nei : graph.getOrDefault(c, Collections.emptySet()))
        {
            if(!topSort(visited,visiting, nei, graph)) return false;
        }
        visiting.remove(c);
        visited.add(c);
        return true;
    }

    public static void main(String args[])
    {
        int[][] grid= new int[][]{{1,1,1,1},{1,1,3,3},{1,1,3,4},{5,5,1,4}};
        isPrintable(grid);
    }
}
