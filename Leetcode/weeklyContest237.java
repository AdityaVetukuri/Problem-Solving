import java.util.*;
public class weeklyContest237 {
    public static int[] getOrder(int tasks[][])
    {
        int n = tasks.length;
        int[] ans  = new int[n];
        int[][] extTasks = new int[n][3];

        for(int i = 0; i < n; i++)
        {
            extTasks[i][0] = i;
            extTasks[i][1] = tasks[i][0];
            extTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(extTasks, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time  = 0;
        int i = 0;
        int ti = 0;
        while(i < n)
        {
            while(ti < n && extTasks[ti][1] <= time)
            {
                q.offer(extTasks[ti++]);
            }
            if(q.isEmpty())
            {
                time = extTasks[ti][1];
                continue;
            }
            int[] bestFit = q.poll();
            time += bestFit[2];
            ans[i++] = bestFit[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        int tasks[][] = new int[][]{{1,2},{2,4},{3,2},{4,1}};
        System.out.println(getOrder(tasks));
    }
}
