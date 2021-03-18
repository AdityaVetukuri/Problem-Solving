import java.util.*;
class criticalConnections {
    ArrayList<Integer>[] graph;
    List<Integer> criticalConnections;
    int[] visitedTimes;
    int[] lowTimes;
    int time;

    public List<Integer> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        criticalConnections = new ArrayList<>();
        visitedTimes = new int[n];
        lowTimes = new int[n];
        time = 0;

        buildGraph(connections);
        boolean[] visited = new boolean[n];
        dfs(visited, 0, -1);
        return criticalConnections;
    }
    private void dfs(boolean[] visited, int currentNode, int parentNode)
    {
        visited[currentNode] = true;
        visitedTimes[currentNode] = lowTimes[currentNode] = time++;

        for(int neighbour : graph[currentNode])
        {
            if(neighbour == parentNode)
                continue;
            if(!visited[neighbour])
            {
                dfs(visited, neighbour,currentNode);
                lowTimes[currentNode] = Math.min(lowTimes[currentNode], lowTimes[neighbour]);
                if(visitedTimes[currentNode]  < lowTimes[neighbour])
                {
                    criticalConnections.add(currentNode);
                }
            }
            else
            {
                lowTimes[currentNode] = Math.min(lowTimes[currentNode],visitedTimes[neighbour]);
            }
        }
    }
    private void buildGraph(List<List<Integer>> connections)
    {
        for(int i =0; i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> connection : connections)
        {
            int head = connection.get(0);
            int tail = connection.get(1);
            graph[head].add(tail);
            graph[tail].add(head);
        }
    }
}