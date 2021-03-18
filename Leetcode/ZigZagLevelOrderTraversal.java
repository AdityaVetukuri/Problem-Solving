import java.util.*;
class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        while(!q.isEmpty())
        {
            int n = q.size();
            List<Integer> nodes = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                TreeNode temp = q.poll();
                nodes.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }

            if(level%2 == 0)
                Collections.reverse(nodes);
            res.add(nodes);
            level++;
        }
        return res;
    }
}