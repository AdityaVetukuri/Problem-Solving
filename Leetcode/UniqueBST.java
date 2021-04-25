
import  java.util.*;

 class TreeNode1 {
    int val;
     TreeNode1 left;
   TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
         this.val = val;
         this.left = left;
       this.right = right;
    }
}

public class UniqueBST {
    static int visited[];
    static List<TreeNode1> resultList;
    public static List<TreeNode1> generateTrees(int n) {
        resultList = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            visited = new int[n];
            Arrays.fill(visited,0);
            visited[i] = 1;
            TreeNode1 root = new TreeNode1(i+1);
            solve(n,root,resultList,visited);
        }
        return resultList;

    }
    public static void solve(int n, TreeNode1 root, List<TreeNode1> resultList, int[] visited)
    {
       for(int i = 0; i < n; i++)
       {

       }
        resultList.add(root);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));
    }
}