import java.util.*;
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
class maxWidthTree {
    int maxWidth = 0;
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int maxWidth = 0;
        map.put(root,0);
        q.add(root);
        int leftMost = 0, rightMost = 0;
        while(!q.isEmpty())
        {
            int n  = q.size();
            for(int i = 0; i < n; i++)
            {

                TreeNode node = q.poll();

                //At any given time left most element in side the queue is the first element
                if(i==0)
                    leftMost = map.get(node);
                //The last element in the queue is the rightmost element
                if(i==n-1)
                    rightMost = map.get(node);
                //if we traverse to the left of a tree we multiply the current value with 2
                if(node.left!=null)
                {
                    q.add(node.left);
                    map.put(node.left,2 * map.get(node));
                }
                //if we traverse right then we multiply the current value with 2 + 1
                if(node.right!=null)
                {
                    q.add(node.right);
                    map.put(node.right, 2 * map.get(node) + 1);
                }
                map.remove(node);
            }
            maxWidth = Math.max(maxWidth, rightMost - leftMost + 1);
        }
        return maxWidth;
    }
}