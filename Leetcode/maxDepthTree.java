

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class maxDepth {
    public int count;
    public int maxDepth(TreeNode root) {
        int left_depth = 0;
        int right_depth = 0;
        count = calculateDepth(root);
        return count;
    }
    public int calculateDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.left ==null && root.right ==null)
        {
            return 1;
        }
        else
        {
            int l = calculateDepth(root.left);
            int r = calculateDepth(root.right);
            return (1 + ((l>r) ? l : r));
        }

    }
}