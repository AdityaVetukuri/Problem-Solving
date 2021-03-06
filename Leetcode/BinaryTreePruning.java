/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        boolean isZero = (root.val == 0);

        if(root.left!=null)
        {
            root.left = pruneTree(root.left);
        }

        if(root.right!=null)
        {
            root.right = pruneTree(root.right);
        }

        if(root.left ==null && root.right == null && isZero)
        {
            return null;
        }
        return root;
    }

}