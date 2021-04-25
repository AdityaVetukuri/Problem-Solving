import java.util.*;
class FrogSideJumps {

    public static int minSideJumps(int[] obstacles) {
        int path = 2;
        int sideMoves = 0;
        int dp[][] = new int[obstacles.length][4];
        for(int i =0; i < dp.length; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacles, path,0,dp);

    }
    public static int helper(int[] obstacles, int path, int index, int dp[][])
    {
        if(index == obstacles.length -1)
        {
            return 0;
        }
        if(obstacles[index] == path) return Integer.MAX_VALUE;
        if(dp[index][path]!=-1)
        return dp[index][path];


        if(obstacles[index + 1] != path)
        {
            dp[index][path] = helper(obstacles,path,index+1,dp);
        }
        else
        {
            int l1 = (path-1!=0)? path-1:path+2;
            int l2 = (path+1 !=4)? path+1:path-2;

            dp[index][path] = 1 + Math.min(helper(obstacles,l1,index,dp),helper(obstacles,l2,index,dp));
        }
        return dp[index][path];
    }

    public static void main(String[] args) {
        int[] lanes = new int[]{0,2,1,0,3,0};
        System.out.println(minSideJumps(lanes));
    }
}