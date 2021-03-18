
public class PalindromicPathsTree {
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null)
            return 0;
        int arr[] = new int[9];
        findLeafPaths(root,arr,0);
        return result;
    }
    public void findLeafPaths(TreeNode root, int[] arr, int odds){
        if(root == null)
            return;
        arr[root.val-1]++;
        if(arr[root.val-1] % 2 == 0)
            odds--;
        else
            odds++;
        if(root.left == null && root.right == null)
        {
            if(odds <= 1)
                result++;
            arr[root.val-1]--;
            return;
        }
        findLeafPaths(root.left,arr,odds);
        findLeafPaths(root.right,arr,odds);
        arr[root.val-1]--;
    }
}