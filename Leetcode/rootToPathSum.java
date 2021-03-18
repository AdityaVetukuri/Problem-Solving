import java.util.*;
class rootToPathSum {
    public int res = 0;
    public int pathSum(TreeNode root, int sum) {
        traverse(root,sum);
        return res;
    }
    public void traverse(TreeNode root,int sum)
    {
        if(root == null)
            return;
        findSums(root, sum, root.val);
        traverse(root.left, sum);
        traverse(root.right, sum);
    }
    public void findSums(TreeNode root,int sum , int value)
    {
        if(root!=null)
        {
            if(sum == value)
                res+=1;
            if(root.left!=null)
                findSums(root.left,sum,value+root.left.val);
            if(root.right!=null)
                findSums(root.right,sum,value+root.right.val);
        }
        return;
    }

}
class alternateSolution {
    int s = 0;

    public void pathSum(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        int localSum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            localSum = localSum + path.get(i);
            if (localSum == sum) {
                s++;
            }
        }
        pathSum(root.left, sum, path);
        pathSum(root.right, sum, path);
        path.remove(path.size() - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new ArrayList<>());
        return s;
    }
}