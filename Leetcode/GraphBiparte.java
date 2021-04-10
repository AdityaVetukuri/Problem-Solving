import java.util.*;
class GraphBiparte {
    public static boolean isBipartite(int[][] graph) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();

        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        map.put(0,set);

        q.add(0);

        while(!q.isEmpty())
        {
            int n = q.size();
            for(int k = 0; k < n; k++) {
                int vertex = q.poll();
                HashSet<Integer> s = new HashSet<>();
                for (int i = 0; i < graph[vertex].length; i++) {
                    if (map.get(vertex).contains(graph[vertex][i]))
                        return false;
                    s.add(graph[vertex][i]);
                    if(map.get(graph[vertex][i])==null) {

                        map.put(graph[vertex][i], s);
                        q.add(graph[vertex][i]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{4,1},{0,2},{1,3},{2,4},{3,0}};
        System.out.println(isBipartite(graph));
    }

}