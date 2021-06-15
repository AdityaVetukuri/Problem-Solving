import java.util.*;
class Pair
{
    int x;
    int y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class BiweeklyContest53 {
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int windowStart = 0, count = 0;
        for(int i = 0 ; i < 3 && i < s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        if(map.size() == 3)
            count++;
        for(int i = 3; i < s.length(); i++)
        {
                char c = s.charAt(i);
                char prev = s.charAt(windowStart);
                map.put(prev, map.getOrDefault(prev, 0) - 1);
                if(map.getOrDefault(prev, 0) == 0)
                    map.remove(prev);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.size() == 3)
                    count++;
                windowStart++;

        }
        return count;
    }
    public int minPairSum(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        int ptr1 = 0, ptr2 = nums.length -1;
        while(ptr1 < ptr2)
        {
            max = Math.max(max, nums[ptr1] + nums[ptr2]);
            ptr1++;
            ptr2--;
        }
        return max;
    }
    public int[] getBiggestThree(int[][] grid) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                list.add(getMaxRhombus(grid, 2, 2, 0, visited));
            }
        }
        return new int[]{1,2,3};
    }

    private int getMaxRhombus(int[][] grid, int i, int j, int sum, boolean[][] visited) {
       Queue<Pair> q = new LinkedList<>();
       Pair obj = new Pair(i,j);
       int res = 0;
       q.add(obj);
       while(!q.isEmpty())
       {
           int n = q.size();
           int ans = 0;
           for(int k = 0 ; k < n; k++)
           {
                Pair curr = q.poll();
                visited[curr.x][curr.y] = true;
                if(curr.x - 1 >= 0 && curr.x + 1 < grid[0].length && curr.y - 1 >= 0 && curr.y + 1 < grid[0].length) {
                    if(visited[curr.x+1][curr.y] != true)
                    {
                        ans += grid[curr.x+1][curr.y];
                        visited[curr.x+1][curr.y] = true;
                    }
                    if(visited[curr.x - 1][curr.y] != true)
                    {
                        ans += grid[curr.x - 1][curr.y];
                        visited[curr.x-1][curr.y] = true;
                    }
                    if(visited[curr.x][curr.y - 1] != true)
                    {
                        ans += grid[curr.x][curr.y - 1];
                        visited[curr.x][curr.y - 1] = true;
                    }
                    if(visited[curr.x][curr.y + 1] != true)
                    {
                        ans += grid[curr.x][curr.y + 1];
                        visited[curr.x][curr.y + 1] = true;
                    }
                    q.add(new Pair(curr.x+1, curr.y));
                    q.add(new Pair(curr.x-1, curr.y));
                    q.add(new Pair(curr.x, curr.y+1));
                    q.add(new Pair(curr.x, curr.y-1));
                }

           }
           res = Math.max(res , ans);
       }
        return res;
    }

    public static void main(String[] args) {
        BiweeklyContest53 obj = new BiweeklyContest53();
        String str = "aababcabc";
      //  obj.countGoodSubstrings(str);
        int[] nums = new int[]{3,5,4,2,4,6};
      //  obj.minPairSum(nums);
        int[][] rhombus = new int[][]{{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        obj.getBiggestThree(rhombus);
    }
}
